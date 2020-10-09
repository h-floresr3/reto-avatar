package com.avatar.films.service;

import com.avatar.films.model.Film;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;
import java.util.ArrayList;


public interface FilmService {
	Flux<ArrayList<Film>> listFilm();

	Mono<Film> listFilmAndCharacter(String uri) throws URISyntaxException;
}
