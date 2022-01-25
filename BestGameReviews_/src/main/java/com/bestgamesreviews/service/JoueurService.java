package com.bestgamesreviews.service;

import java.sql.SQLException;
import java.util.Optional;
import com.bestgamesreviews.entity.Joueur;

/**
 * Interface de service des entités Joueur
 * 
 * @author Marielle Michael Rudolph
 *
 */

public interface JoueurService {

	/**
	 * Ajoute un nouveau joueur
	 * 
	 * @param Jouer joueur
	 * @return Jouer joueur
	 */
	Joueur addJoueur(Joueur joueur) throws SQLException;

	/**
	 * Trouve un utilisateur
	 * 
	 * @param String pseudo
	 * @param String password
	 * @return Joueur Joueur
	 */
	Joueur findJoueur(String pseudo, String password) throws SQLException;

	/**
	 * Trouver un joueur par son id
	 * 
	 * @param Long id
	 * @return Optional<Joueur> joueur
	 */
	Optional<Joueur> find(Long id) throws SQLException;
}
