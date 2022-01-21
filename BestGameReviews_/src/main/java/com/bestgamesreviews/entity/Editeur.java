/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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

	@OneToMany(mappedBy = "jeu")
	List<Jeux> listeJeux = new ArrayList<>();

	/**
	 * Empty constructor
	 */

	public Editeur() {
	}
}
