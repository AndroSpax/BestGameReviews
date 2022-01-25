/**
 * 
 */
package com.bestgamesreviews.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bestgamesreviews.dao.ClassificationDAO;
import com.bestgamesreviews.dao.EditeurDAO;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.entity.Classification;
import com.bestgamesreviews.entity.Editeur;
import com.bestgamesreviews.entity.Genre;
import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.entity.Joueur;
import com.bestgamesreviews.entity.ModeleEconomique;
import com.bestgamesreviews.entity.Moderateur;
import com.bestgamesreviews.entity.Plateforme;
import com.bestgamesreviews.entity.Utilisateur;
import com.bestgamesreviews.exception.AvisException;
import com.bestgamesreviews.exception.ClassificationException;
import com.bestgamesreviews.exception.EditeurException;
import com.bestgamesreviews.exception.GenreException;
import com.bestgamesreviews.exception.JeuxException;
import com.bestgamesreviews.exception.ModeleEconomiqueException;
import com.bestgamesreviews.exception.PlateformeException;
import com.bestgamesreviews.exception.UtilisateurException;
import com.bestgamesreviews.service.AvisService;
import com.bestgamesreviews.service.AvisServiceImpl;
import com.bestgamesreviews.service.ClassificationService;
import com.bestgamesreviews.service.ClassificationServiceImpl;
import com.bestgamesreviews.service.EditeurService;
import com.bestgamesreviews.service.EditeurServiceImpl;
import com.bestgamesreviews.service.GenreService;
import com.bestgamesreviews.service.GenreServiceImpl;
import com.bestgamesreviews.service.IUtilisateurService;
import com.bestgamesreviews.service.JeuxService;
import com.bestgamesreviews.service.JeuxServiceImpl;
import com.bestgamesreviews.service.ModeleEconomiqueImpl;
import com.bestgamesreviews.service.ModeleEconomiqueService;
import com.bestgamesreviews.service.PlateformeService;
import com.bestgamesreviews.service.PlateformeServiceImpl;
import com.bestgamesreviews.service.UtilisateurServiceImpl;

import lombok.AllArgsConstructor;

/**
 * @author Marielle Machael Rudolph C'est un contrôleur qui initialise des bojet
 *         et les persite en base de données
 */

@AllArgsConstructor
@Controller
public class InitController {
	/**
	 * init des service
	 */
	private final ClassificationService classificationServiceImpl;
	private final GenreService genreServiceImpl;
	private final EditeurService editeurServiceImpl;
	private final PlateformeService plateformeServiceImpl;
	private final ModeleEconomiqueService modeleEconomiqueImpl;
	private final AvisService avisService;
	private final JeuxService jeuxServiceImpl;
	private final IUtilisateurService utilisateurServiceImpl;
	
	



	// Dès que Spring a injecté tous les objets, il invoque ttes les méthodes
	// annotées PostConstruct
	//@PostConstruct
	private void init() throws AvisException, GenreException, EditeurException, PlateformeException, ModeleEconomiqueException, UtilisateurException, JeuxException {
		/*
		 * Classification(String no)
		 */
		Classification classification = new Classification("Pegi12");
		Classification classification1 = new Classification("Pegi16");

		
		
			
			try {
				classification = classificationServiceImpl.persiste(classification);
				classification1 = classificationServiceImpl.persiste(classification1);
			} catch (ClassificationException e) {
				e.printStackTrace();
			}
		
		/*
		 * Genre(String nom)
		 */
		Genre genre = new Genre("Combat");
		Genre genre1 = new Genre("PlateForme");
		// persiste en base
		genre = genreServiceImpl.persiste(genre);
		genre1 = genreServiceImpl.persiste(genre1);

		/*
		 * Editeur(String nom)
		 */
		Editeur editeur = new Editeur("UBISOFT");
		Editeur editeur1 = new Editeur("EA Games");
		// persiste en base
		editeur = editeurServiceImpl.persiste(editeur);
		editeur1 = editeurServiceImpl.persiste(editeur1);

		/*
		 * Plateforme(String nom)
		 */
		List<Plateforme> plateformes = new ArrayList<>();
		Plateforme plateforme1 = new Plateforme("PlayStation2");
		Plateforme plateforme2 = new Plateforme("PlayStation1");
		// persiste en base
		plateforme1 = plateformeServiceImpl.persiste(plateforme1);
		plateforme2 = plateformeServiceImpl.persiste(plateforme2);
		
		/*
		 * add plateforme into list
		 */
		plateformes.add(plateforme1);
		plateformes.add(plateforme2);

		/*
		 * ModeleEconomique(String nom)
		 */
		ModeleEconomique modeleEconomique = new ModeleEconomique("Pay to play");
		ModeleEconomique modeleEconomique1 = new ModeleEconomique("Free to play, pay to win");
		// persiste en base
		modeleEconomique = modeleEconomiqueImpl.persiste(modeleEconomique);
		modeleEconomique1 = modeleEconomiqueImpl.persiste(modeleEconomique1);
		

		/*
		 * Moderateur ( String pseudo, String motDePasse, String email,String
		 * numeroDetelephone)
		 */
		Utilisateur moderateur = new Moderateur("totoBG", "totoBG", "totoBG@gmail.com", "064646084536");
		Utilisateur moderateur1 = new Moderateur("tataBG", "tataBG", "tataBG@gmail.com", "064646084538");
		// persiste en base
		moderateur = utilisateurServiceImpl.persiste(moderateur);
		moderateur1 = utilisateurServiceImpl.persiste(moderateur1);


		/*
		 * Joueur(@NotEmpty(message = "Un pseudo est indispensable") String pseudo,
		 * 
		 * @NotEmpty(message = "Un mot de passe est indispensable") String motDePasse,
		 * 
		 * @NotEmpty(message = "Un email est indispensable") String email,LocalDate
		 * dateDenaissance)
		 */
		Utilisateur joueur = new Joueur("titiBG", "titiBG", "titiBG@gmail.com", LocalDate.now());
		Utilisateur joueur1 = new Joueur("tutuBG", "tutuBG", "tutuBG@gmail.com", LocalDate.now());
		// persiste en base
		joueur = utilisateurServiceImpl.persiste(joueur);
		joueur1 = utilisateurServiceImpl.persiste(joueur1);

		/*
		 * Jeux(String nom, String description, LocalDate dateSortie, String image,
		 * Classification classification, Genre genre, Editeur editeur, List<Plateforme>
		 * listePlateforme, ModeleEconomique modeleEconomique)
		 */
		Jeux jeux = new Jeux("paul", "jeux de rôle d'un alien qui veux quitter la terre", LocalDate.now(), "src/img",
				classification, genre, editeur, plateformes, modeleEconomique1);
		Jeux jeux2 = new Jeux("Medal of Honor", "jeux de rôle d'un alien qui veux quitter la terre", LocalDate.now(),
				"src/img", classification1, genre1, editeur1, plateformes, modeleEconomique);
		// persiste en base
		jeux = jeuxServiceImpl.persiste(jeux);
		jeux2 = jeuxServiceImpl.persiste(jeux2);

		/*
		 * Avis(@NotEmpty(message = "Une description est indispensable") String
		 * description, LocalDate dateEnvoi, Float note, LocalDate dateModeration, Jeux
		 * jeu, Joueur joueur, Moderateur moderateur)
		 */
		Avis avis = new Avis("c'est un avis", LocalDate.now(), 12.5F, LocalDate.now(), jeux, (Joueur) joueur,
				(Moderateur) moderateur);
		Avis avis1 = new Avis("c'est un deuxiéme avis", LocalDate.now(), 12.5F, LocalDate.now(), jeux2,
				(Joueur) joueur1, (Moderateur) moderateur1);
		// persiste en base
				avis = avisService.persiste(avis);
				avis1 = avisService.persiste(avis1);
		

	}
}
