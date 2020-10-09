package com.avatar.films.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.avatar.films.config.ApplicationProperties;
import com.avatar.films.model.Film;
import com.avatar.films.model.Page;
import com.avatar.films.model.Character;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	ApplicationProperties applicationProperties;

	@Override
	public Flux<ArrayList<Film>> listFilm() {
		final WebClient client = WebClient.create(applicationProperties.getUriService());
		List<Page> filmDtoFlux = client.get().retrieve().bodyToFlux(Page.class).collectList().block();
		ArrayList<Film> fillAll = new ArrayList<>();
		filmDtoFlux.forEach(m -> {
			m.getFilmAll().forEach(p -> {
				fillAll.add(p);
			});
		});

		return Flux.just(fillAll);
	}

	@Override
	public Mono<Film> listFilmAndCharacter(String uri) throws URISyntaxException {
		final WebClient client = WebClient.create(this.convertToHttps(uri));
		System.out.println("URI: " + uri);
		Mono<Film> filmDtoFlux = client.get().retrieve().bodyToMono(Film.class);
		Film film = filmDtoFlux.block();
		film.setCharacters(filmDtoFlux.block().getCharacters().stream().map(
				c -> {
					try {
						final WebClient webClient = WebClient.create(this.convertToHttps(c));
						Character characterDtoList = webClient.get().retrieve().bodyToFlux(Character.class).blockFirst();
						return characterDtoList.getName();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}

					return "";
				}

		).collect(Collectors.toList()));
		return Mono.just(film);
	}
	private String convertToHttps(String uri) throws URISyntaxException {
		URI uriOld = URI.create(uri);
		URI mutatedUri = new URI("https",
				uriOld.getUserInfo(),
				uriOld.getHost(),
				uriOld.getPort(),
				uriOld.getPath(),
				uriOld.getQuery(),
				uriOld.getFragment());
		return mutatedUri.toString();
	}
}
