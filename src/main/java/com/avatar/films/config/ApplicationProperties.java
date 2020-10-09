package com.avatar.films.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApplicationProperties {
	@Value("${api.rest.uri.film}")
	private String uriService;

}
