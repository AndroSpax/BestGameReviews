/**
 * 
 */
package com.bestgamesreviews.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marielle Machael Rudolph 
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Joueur extends Utilisateur {
	
	private LocalDate dateDenaissance;
	
	/**
	 * Empty constructor
	 */
	public Joueur() {
	}

}
