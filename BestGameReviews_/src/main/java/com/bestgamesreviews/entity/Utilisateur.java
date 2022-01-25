/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class Utilisateur {
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
}
