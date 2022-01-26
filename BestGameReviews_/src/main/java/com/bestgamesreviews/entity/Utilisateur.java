/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public abstract class Utilisateur implements UserDetails{
/*
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements UserDetails {
*/

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	protected Long id;
	@Column(unique = true)
	@NotEmpty(message = "Un pseudo est indispensable")
	protected String pseudo;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotEmpty(message = "Un mot de passe est indispensable")
	protected String motDePasse;
	@Column(unique = true)
	@NotEmpty(message = "Un email est indispensable")
	protected String email;

	/**
	 * Empty construtor
	 */

	public Utilisateur() {
	}

	/**
	 * pour la création
	 * @param pseudo
	 * @param motDePasse
	 * @param email
	 */
	public Utilisateur(@NotEmpty(message = "Un pseudo est indispensable") String pseudo,
			@NotEmpty(message = "Un mot de passe est indispensable") String motDePasse,
			@NotEmpty(message = "Un email est indispensable") String email) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;
	}
	
	
}
