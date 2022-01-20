/**
 * 
 */
package org.formation.entity;

import java.time.LocalDate;

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
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Jeux {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	private String nom;
	private String description;
	private LocalDate dateSortie;
	private String image;
	
	/***
	 * Empty constructor
	 */
	public Jeux() {
	}
	

}
