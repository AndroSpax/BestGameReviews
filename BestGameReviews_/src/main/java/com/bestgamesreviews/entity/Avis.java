/**
 *
 */
package com.bestgamesreviews.entity;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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

	private String description;
	private LocalDate dateEnvoi;
	private Float note;
	private LocalDate dateModeration;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "jeux_id")
	private Jeux jeu;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "joueur_id")
	private Joueur joueur;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "moderateur_id")
	private Moderateur moderateur;

	/**
	 * Empty constructor
	 */

	public Avis() {
	}
}
