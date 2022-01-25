/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * un éditeur produit plusieurs jeux
 * @author Marielle Machael Rudolph 
 *
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "editeur")
	private List<Jeux> listeJeux = new ArrayList<>();

	/**
	 * Empty constructor
	 */
	public Editeur() {
	}

	/**
	 * pour la création
	 * @param nom
	 */
	public Editeur(String nom) {
		super();
		this.nom = nom;
	}
	
	
}
