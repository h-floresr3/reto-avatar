package com.avatar.films.model;

import java.util.ArrayList;

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
public class Character {

	private String name;

	  private String height;

	  private String mass;

	  @JsonProperty("hair_color")
	  private String hairColor;

	  @JsonProperty("skin_color")
	  private String skinColor;

	  @JsonProperty("eye_color")
	  private String eyeColor;

	  @JsonProperty("birth_year")
	  private String birthYear;

	  private String gender;

	  private String homeworld;

	  ArrayList<String> films = new ArrayList<>();

	  ArrayList<String> species = new ArrayList<>();

	  ArrayList<String> vehicles = new ArrayList<>();

	  ArrayList<String> starships = new ArrayList<>();

	  private String created;

	  private String edited;

	  private String url;
}
