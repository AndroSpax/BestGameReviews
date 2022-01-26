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

    @OneToMany(mappedBy = "jeu", cascade = CascadeType.REMOVE)
    private List<Avis> listeAvis = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "classification_id")
    private Classification classification;

    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne()
    @JoinColumn(name = "editeur")
    private Editeur editeur;

    @ManyToMany() 
    @JoinTable(name = "jeux_plateformes", joinColumns = {@JoinColumn(name = "jeu_id")},
    inverseJoinColumns = {@JoinColumn(name = "plateforme_id")})
    private List<Plateforme> listePlateforme = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "modele_economique_id")
    private ModeleEconomique modeleEconomique;

    /***
     * Empty constructor
     */

    public Jeux() {
    }

	/**
	 * @param nom
	 * @param description
	 * @param dateSortie
	 * @param image
	 * @param listeAvis
	 * @param classification
	 * @param genre
	 * @param editeur
	 * @param listePlateforme
	 * @param modeleEconomique
	 */
	public Jeux(String nom, String description, LocalDate dateSortie, String image, List<Avis> listeAvis,
			Classification classification, Genre genre, Editeur editeur, List<Plateforme> listePlateforme,
			ModeleEconomique modeleEconomique) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateSortie = dateSortie;
		this.image = image;
		this.listeAvis = listeAvis;
		this.classification = classification;
		this.genre = genre;
		this.editeur = editeur;
		this.listePlateforme = listePlateforme;
		this.modeleEconomique = modeleEconomique;
	}

	/**
	 * pour la création
	 * @param nom
	 * @param description
	 * @param dateSortie
	 * @param image
	 * @param classification
	 * @param genre
	 * @param editeur
	 * @param listePlateforme
	 * @param modeleEconomique
	 */
	public Jeux( String nom, String description, LocalDate dateSortie, String image,
			Classification classification, Genre genre, Editeur editeur, List<Plateforme> listePlateforme,
			ModeleEconomique modeleEconomique) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateSortie = dateSortie;
		this.image = image;
		this.classification = classification;
		this.genre = genre;
		this.editeur = editeur;
		this.listePlateforme = listePlateforme;
		this.modeleEconomique = modeleEconomique;
	}

	/**
	 * add plateforme into game
	 * @param plateforme
	 * @return
	 */
	public List<Plateforme> addPlateforme(Plateforme plateforme) {
		this.listePlateforme.add(plateforme);
		return this.listePlateforme;
	}
    
	/**
	 * add avis into this game 
	 * @param avis
	 * @return
	 */
	public List<Avis> addPlateforme(Avis avis) {
		this.listeAvis.add(avis);
		return this.listeAvis;
	}

}
