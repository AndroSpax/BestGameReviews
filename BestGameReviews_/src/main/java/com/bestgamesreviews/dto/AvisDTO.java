/**
 * 
 */
package com.bestgamesreviews.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Administrator
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvisDTO {

	private Long id;
	private String nom;
	private Long jeu_id;
    private LocalDate dateEnvoi;
    private String description;
    private Float note;
    private String auteur;
    private Long auteur_id;
    private String image;
    private Boolean statut;
    private String moderateur;
    private Long moderateur_id;
    
}
