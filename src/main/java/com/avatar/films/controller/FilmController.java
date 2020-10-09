package com.avatar.films.controller;

import com.avatar.films.model.Film;
import com.avatar.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class FilmController {

	@Autowired
	private FilmService filmService;

	@RequestMapping("/films")
	public String FilmAll(final Model model) {
		Flux<ArrayList<Film>> filmDtoFlux = this.filmService.listFilm();
		model.addAttribute("listFilm", filmDtoFlux.blockFirst());
		return "films";
	}

	@RequestMapping("/film")
	public String filmAndCharacterFlux(@RequestParam String url,final Model model) throws URISyntaxException {
		Mono<Film> filmDtoFlux = this.filmService.listFilmAndCharacter(url);
		model.addAttribute("film", filmDtoFlux.block());
		return "film";

	}
}
