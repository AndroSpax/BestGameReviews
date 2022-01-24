/**
 *
 */
package com.bestgamesreviews.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Un joueur à une liste d'avis
 * @author Marielle Machael Rudolph 
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Joueur extends Utilisateur {

	@NotEmpty(message = "Une date de naissance est indispensable")
    private LocalDate dateDenaissance;

	@JsonIgnore
    @OneToMany(mappedBy = "joueur", cascade = CascadeType.PERSIST)
    private List<Avis> listeAvis = new ArrayList<>();

    /**
     * Empty constructor
     */

    public Joueur() {
    }

}
