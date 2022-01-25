/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Marielle Machael Rudolph 
 *
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements UserDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	protected Long id;
	protected String pseudo;
	protected String motDePasse;
	protected String email;

	/**
	 * Empty construtor
	 */

	public Utilisateur() {
	}
}
