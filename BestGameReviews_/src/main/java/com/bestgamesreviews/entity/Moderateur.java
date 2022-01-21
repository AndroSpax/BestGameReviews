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
public class Moderateur extends Utilisateur{

	private String numeroDetelephone;
	
	/**
	 * Empty constructor
	 */
	public Moderateur() {
	}
}
