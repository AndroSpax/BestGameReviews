package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.entity.Plateforme;

/**
 * Interface de service des enttés Plateforme
 * @author Marielle Michael Rudolph
 *
 */
public interface PlateformeService {

	/**
	 * Mehtode qui renvoie toues les plateforme qui sont en base de données
	 * Elle prend aucun parmetre
	 * @return
	 */
	List<Plateforme> getAll();
}
