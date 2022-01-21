/**
 *
 */
package com.bestgamesreviews.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Un joueur à une liste d'avis
 * @author Marielle Machael Rudolph 
 *
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Joueur extends Utilisateur {

    private LocalDate dateDenaissance;

    @OneToMany(mappedBy = "avis", cascade = CascadeType.PERSIST)
    private List<Avis> listeAvis = new ArrayList<>();

    /**
     * Empty constructor
     */

    public Joueur() {
    }

}
