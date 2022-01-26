package com.bestgamesreviews.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class JeuxDTO {
	
	private Long id;
	private String nom;
	private String editeur;
	private LocalDate dateDeSortie;
	private String description;
	private String genre;
	private String string;
	private String classification;
	private String plateforme; 
	private String modeleEconomique; 
}
