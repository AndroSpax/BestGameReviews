/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.ConstructorBinding;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * une classification est mis sur différents jeux
 * @author Marielle Machael Rudolph 
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@ConstructorBinding
public class Classification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "classification", cascade = CascadeType.PERSIST)
	private List<Jeux> listeJeux= new ArrayList<>();

	/**
	 * Empty constructor
	 */

	public Classification() {
	}

	/**
	 * pour la création
	 * @param nom
	 * @param listeJeux
	 */
	public Classification(String nom) {
		this.nom = nom;
	}
	
}
