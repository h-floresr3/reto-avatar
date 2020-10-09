package com.avatar.films.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Page {

	private float count;

	private String next = null;

	private String previous = null;

	@JsonProperty("results")
	ArrayList<Film> filmAll = new ArrayList<>();
}
