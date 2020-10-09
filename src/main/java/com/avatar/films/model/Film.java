package com.avatar.films.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film {

	private String title;

	  @JsonProperty("episode_id")
	  private float episodeId;

	  @JsonProperty("opening_crawl")
	  private String openingCrawl;

	  private String director;

	  private String producer;

	  private String release_date;

	  List<String> characters = new ArrayList<>();

	List<String> planets = new ArrayList<>();

	List<String> starships = new ArrayList<>();

	List<String> vehicles = new ArrayList<>();

	List<String> species = new ArrayList<>();

	  private String created;

	  private String edited;

	  private String url;
	
}
