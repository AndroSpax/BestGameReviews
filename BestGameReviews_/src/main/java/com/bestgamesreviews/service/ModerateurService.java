package com.bestgamesreviews.service;

import java.sql.SQLException;
import java.util.Optional;

import com.bestgamesreviews.entity.Moderateur;

/**
 * Interface de service des entités modérateur
 * @author Marielle Michael Rudolph
 *
 */
public interface ModerateurService {

	/**
	 * Ajoute un nouveau Moderateur
	 * 
	 * @param Jouer Moderateur
	 * @return Jouer Moderateur
	 */
	Moderateur addModerateur(Moderateur Moderateur) throws SQLException;

	/**
	 * Trouve un Modérateur
	 * 
	 * @param String pseudo
	 * @param String password
	 * @return Moderateur Moderateur
	 */
	Moderateur findModerateur(String pseudo, String password) throws SQLException;

	/**
	 * Trouver un Moderateur par son id
	 * 
	 * @param Long id
	 * @return Optional<Moderateur> Moderateur
	 */
	Optional<Moderateur> find(Long id) throws SQLException;
}
