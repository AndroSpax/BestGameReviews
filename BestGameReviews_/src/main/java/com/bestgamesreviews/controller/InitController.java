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
	 * init des services
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
	@PostConstruct
	private void init() throws AvisException, GenreException, EditeurException, PlateformeException,
			ModeleEconomiqueException, UtilisateurException, JeuxException, ClassificationException {

		/*
		 * Moderateur ( String pseudo, String motDePasse, String email,String
		 * numeroDetelephone)
		 */
		Utilisateur moderateur = new Moderateur("totoBG", "totoBG", "totoBG@gmail.com", "064646084536");
		Utilisateur moderateur1 = new Moderateur("tataBG", "tataBG", "tataBG@gmail.com", "064646084538");

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

		/**
		 * on doit vérifier si les email sont déjà en base de données
		 */

		/*
		 * Classification(String no)
		 */
		Classification classification = new Classification("Pegi12");
		Classification classification1 = new Classification("Pegi16");

		/*
		 * Genre(String nom)
		 */
		Genre genre = new Genre("Combat");
		Genre genre1 = new Genre("PlateForme");

		/*
		 * Editeur(String nom)
		 */
		Editeur editeur = new Editeur("UBISOFT");
		Editeur editeur1 = new Editeur("EA Games");

		/*
		 * Plateforme(String nom)
		 */
		List<Plateforme> plateformes = new ArrayList<>();
		Plateforme plateforme1 = new Plateforme("PlayStation2");
		Plateforme plateforme2 = new Plateforme("PlayStation1");

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

		/*
		 * Jeux(String nom, String description, LocalDate dateSortie, String image,
		 * Classification classification, Genre genre, Editeur editeur, List<Plateforme>
		 * listePlateforme, ModeleEconomique modeleEconomique)
		 */
		Jeux jeux = new Jeux("paul", "jeux de rôle d'un alien qui veux quitter la terre", LocalDate.now(), "src/img",
				classification, genre, editeur, plateformes, modeleEconomique1);
		Jeux jeux2 = new Jeux("Medal of Honor", "jeux de rôle d'un alien qui veux quitter la terre", LocalDate.now(),
				"src/img", classification1, genre1, editeur1, plateformes, modeleEconomique);

		// persiste en base classification
		classificationServiceImpl.persiste(classification);
		classificationServiceImpl.persiste(classification1);

		// persiste en base genre
		genreServiceImpl.persiste(genre);
		genreServiceImpl.persiste(genre1);

		// persiste en base editeur
		editeurServiceImpl.persiste(editeur);
		editeurServiceImpl.persiste(editeur1);

		// persiste en base modeleEco
		modeleEconomiqueImpl.persiste(modeleEconomique);
		modeleEconomiqueImpl.persiste(modeleEconomique1);

		// persiste en base plateForme
		plateformeServiceImpl.persiste(plateforme1);
		plateformeServiceImpl.persiste(plateforme2);

		// ajout des plateformes dans jeu
		jeux.addPlateforme(plateforme2);
		jeux.addPlateforme(plateforme1);

		jeux2.addPlateforme(plateforme2);
		jeux2.addPlateforme(plateforme1);

		// persiste en base
		jeuxServiceImpl.persiste(jeux);
		jeuxServiceImpl.persiste(jeux2);

		// persiste en base moderateur
		moderateur = verifId(moderateur);
		moderateur1 = verifId(moderateur1);

		// persiste en base joueur
		joueur = verifId(joueur);
		joueur1 = verifId(joueur1);

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
		avisService.persiste(avis);
		avisService.persiste(avis1);

	}

	/**
	 * Methode qui verifi si il y à un utilisateur avec le même email.
	 * !!!!!! ATTENTION !!!!!!! 
	 * Fonction à utiliser que dans initControleur
	 * @param utilisateur
	 * @return
	 * @throws UtilisateurException
	 */
	public Utilisateur verifId(Utilisateur utilisateur) throws UtilisateurException {
		utilisateur = utilisateurServiceImpl.getByEmail(utilisateur);
		if (!(utilisateur.getId() != null)) {
			utilisateurServiceImpl.persiste(utilisateur);
		}
		return utilisateur;
	}

}
