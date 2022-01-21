/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
