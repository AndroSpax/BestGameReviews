package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.exception.JeuxException;

/**
 * Interface de service des entités Jeux
 * 
 * @author Marielle Michael Rudolph
 *
 */
public interface JeuxService {

	/**
	 * persiste un jeu en base si ce dernier contient bien un nom il retourne un
	 * Objet Jeux
	 * 
	 * @param jeux
	 * @return 
	 * @throws JeuxException
	 */
	Jeux persiste(Jeux jeux) throws JeuxException;

	/**
	 * Charge la liste des jeux
	 * 
	 * @return List<Jeux> listeJeux
	 */
	List<Jeux> findAll();

	/**
	 * Supprime un jeux dans la base de données
	 * @param Long id
	 * @return
	 */
	String deleteAvis(Long id);
}
