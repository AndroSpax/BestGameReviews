/**
 *
 */
package com.bestgamesreviews.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * un jeu à une liste d'avis
 * un jeu à une classification
 * un jeu à un genre
 * un jeu est produit par un éditeur
 * un jeu peut être disponible sur plusieurs plateforme
 * un jeu à un ModeleEconomque
 * @author Marielle Machael Rudolph
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

    @OneToMany(mappedBy = "avis", cascade = CascadeType.PERSIST)
    private List<Avis> listeAvis = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classification")
    private Classification classification;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "editeur")
    private Editeur editeur;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "jeux_plateformes", joinColumns = {@JoinColumn(name = "jeu")},
            inverseJoinColumns = {@JoinColumn(name = "plateforme")})
    private List<Plateforme> listePlateforme = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "modele economique")
    private ModeleEconomique modeleEconomique;

    /***
     * Empty constructor
     */

    public Jeux() {
    }


}
