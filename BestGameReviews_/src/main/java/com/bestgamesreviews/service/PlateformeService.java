package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.entity.Plateforme;
import com.bestgamesreviews.exception.PlateformeException;

/**
 * Interface de service des enttés Plateforme
 * 
 * @author Marielle Michael Rudolph
 *
 */
public interface PlateformeService {

	/**
	 * Mehtode qui renvoie toues les plateforme qui sont en base de données Elle
	 * prend aucun parmetre
	 * 
	 * @return
	 */
	List<Plateforme> getAll();

	/**
	 * persiste une plateforme en base si ce dernier contient bien un nom
	 * il retourne un Objet plateforme
	 * @param plateforme
	 * @return
	 * @throws PlateformeException 
	 */
	Plateforme persiste(Plateforme plateforme) throws PlateformeException;
}
