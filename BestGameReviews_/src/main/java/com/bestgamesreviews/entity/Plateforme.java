/**
 *
 */
package com.bestgamesreviews.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * une plateforme est disponible pour différents jeux
 * @author Marielle Machael Rudolph 
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Plateforme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String nom;

    @ManyToMany(mappedBy = "listePlateforme", cascade = CascadeType.PERSIST)
    private List<Jeux> listeJeux = new ArrayList<>();

    /**
     * Empty constructor
     */
    public Plateforme() {
    }
}
