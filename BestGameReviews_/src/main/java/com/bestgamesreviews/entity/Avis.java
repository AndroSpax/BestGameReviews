/**
 *
 */
package com.bestgamesreviews.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Un avis est mis sur un jeu Un avis est déposé par un joueur
 * 
 * @author Marielle Machael Rudolph
 */

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@NotEmpty(message = "Une description est indispensable")
	private String description;
	private LocalDate dateEnvoi;
	private Float note;
	private LocalDate dateModeration;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "jeux_id")
	private Jeux jeu;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "joueur_id")
	private Joueur joueur;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "moderateur_id")
	private Moderateur moderateur;

	/**
	 * Empty constructor
	 */

	public Avis() {
	}

	/**
	 * pour la création
	 * @param description
	 * @param dateEnvoi
	 * @param note
	 * @param dateModeration
	 * @param jeu
	 * @param joueur
	 * @param moderateur
	 */
	public Avis(@NotEmpty(message = "Une description est indispensable") String description, LocalDate dateEnvoi,
			Float note, LocalDate dateModeration, Jeux jeu, Joueur joueur, Moderateur moderateur) {
		super();
		this.description = description;
		this.dateEnvoi = dateEnvoi;
		this.note = note;
		this.dateModeration = dateModeration;
		this.jeu = jeu;
		this.joueur = joueur;
		this.moderateur = moderateur;
	}
	
	
}

