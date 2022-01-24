/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Marielle Machael Rudolph 
 *
 */
@Getter
@Setter
@AllArgsConstructor
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class Utilisateur {
	
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
	 * 
	 */

	public Utilisateur() {
	}
}
