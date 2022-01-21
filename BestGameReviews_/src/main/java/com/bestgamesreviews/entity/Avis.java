/**
 * 
 */
package com.bestgamesreviews.entity;

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
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	private String description;
	private LocalDate dateEnvoi;
	private Float note;
	private LocalDate dateModeration;
	
	/**
	 * Empty constructor
	 */
	public Avis() {
	}
}
