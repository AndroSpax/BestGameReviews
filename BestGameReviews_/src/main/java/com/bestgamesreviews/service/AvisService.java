package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.exception.AvisException;

/**
 * Interface de service des entités Avis
 * 
 * @author Marielle Michael Rudolph
 *
 */
public interface AvisService {

	/**
	 * Charge la liste des avis
	 * 
	 * @return List<Avis> listeAvis
	 */
	List<Avis> findAll();

	/**
	 * Ajoute/Sauvergarde un nouvel avis
	 * 
	 * @param Avis avis
	 * @return Avis avis
	 */
	Avis addAvis(Avis avis);

	/**
	 * Valide (ajoute un modérateur à un avis) un avis
	 * 
	 * @param Avis avis
	 * @return : renvoie l'objet modifier
	 */
	Avis validateAvis(Avis avis);

	/**
	 * Supprime un avis
	 * 
	 * @param Long id
	 * @return String : "Avis " + id + " supprimée"
	 */
	String deleteAvis(Long id);

	/**
	 * ajoute un avis en base
	 * @param avis
	 * @return
	 * @throws AvisException 
	 */
	Avis persiste(Avis avis) throws AvisException;
}
