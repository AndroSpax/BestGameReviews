/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

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
public abstract class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	protected Long id;
	protected String pseudo;
	protected String motDePasse;
	protected String email;
	
	/**
	 * 
	 */
	public Utilisateur() {
	}
}
