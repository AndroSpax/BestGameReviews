package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.entity.ModeleEconomique;
import com.bestgamesreviews.exception.ModeleEconomiqueException;

/**
 * Interface de service des entité ModeleEconomique
 * 
 * @author Marielle Michael Rudolph
 *
 */
public interface ModeleEconomiqueService {

	/**
	 * persiste une modeleEconomique en base si ce dernier contient bien un nom il
	 * retourne un Objet modeleEconomique
	 * 
	 * @param modeleEconomique
	 * @return
	 * @throws ModeleEconomiqueException
	 */
	ModeleEconomique persiste(ModeleEconomique modeleEconomique) throws ModeleEconomiqueException;

	/**
	 * Service permetant de renvoyer tous les modèles économiques présent en base de
	 * donnée
	 * 
	 * @return List<ModeleEconomique>
	 */
	List<ModeleEconomique> getAll();
}
