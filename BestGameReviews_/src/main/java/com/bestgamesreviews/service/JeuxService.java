package com.bestgamesreviews.service;

import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.exception.JeuxException;

/**
 * Interface de service des entités Jeux
 * @author Marielle Michael Rudolph
 *
 */
public interface JeuxService {

	/**
	 *  persiste un jeu en base si ce dernier contient bien un nom
	 * il retourne un Objet Jeux
	 * @param jeux
	 * @return
	 * @throws JeuxException 
	 */
	Jeux persiste(Jeux jeux) throws JeuxException;
}
