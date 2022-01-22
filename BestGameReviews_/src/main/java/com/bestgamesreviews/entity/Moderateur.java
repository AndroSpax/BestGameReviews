/**
 * 
 */
package com.bestgamesreviews.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marielle Machael Rudolph
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="moderateur")
@DiscriminatorValue("F")
public class Moderateur extends Utilisateur{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	protected Long id;
	private String numeroDetelephone;

	/**
	 * Empty constructor
	 */
	public Moderateur() {
	}
}
