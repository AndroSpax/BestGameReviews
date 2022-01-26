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
 * une plateforme est disponible pour différents jeux
 * @author Marielle Machael Rudolph 
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Plateforme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String nom;

    @JsonIgnore
    @ManyToMany(mappedBy = "listePlateforme")
    private List<Jeux> listeJeux = new ArrayList<>();

    /**
     * Empty constructor
     */
    public Plateforme() {
    }

	/**
	 * pour la création
	 * @param nom
	 */
	public Plateforme(String nom) {
		super();
		this.nom = nom;
	}
    
	
    
}
