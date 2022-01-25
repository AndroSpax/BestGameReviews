package com.bestgamesreviews.service;

import com.bestgamesreviews.entity.Editeur;
import com.bestgamesreviews.exception.EditeurException;

/**
 * Interface de service des entitée Editeur
 * @author Marielle Michael Rudolph
 *
 */
public interface EditeurService {

	/**
	 * persiste un editeur en base si ce dernier contient bien un nom
	 * il retourne un Objet editeur
	 * @param genre
	 * @param editeur
	 * @return
	 * @throws EditeurException
	 */
	Editeur persiste(Editeur editeur) throws EditeurException;
}
