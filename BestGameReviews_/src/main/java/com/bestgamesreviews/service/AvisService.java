package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.dto.AvisDTO;
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
	AvisDTO addAvis(AvisDTO avis);

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
	 * 
	 * @param avis
	 * @return
	 * @throws AvisException
	 */
	Avis persiste(Avis avis) throws AvisException;

	/**
	 * Charge la liste des avisDto
	 * 
	 * @return
	 */
	List<AvisDTO> findAllDTO();

	/**
	 * Recupere un avis, et y ajoute le modérateur qui l'a valider ainsi que la date
	 * de la validation
	 * 
	 * @param id_avis
	 * @param id_mod
	 * @return AvisDTO
	 */
	AvisDTO modererAvis(Long id_avis, Long id_mod);

	/**
	 * Transforme un avis en avisdto
	 * 
	 * @param avis
	 * @return avisDto
	 */
	public AvisDTO transformeDto(Avis e);
}
