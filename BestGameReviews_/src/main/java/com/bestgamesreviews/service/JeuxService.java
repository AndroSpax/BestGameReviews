package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.dto.JeuxDTO;
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
	 * Permet de transformer un objet Jeux en JeuxDTO
	 * 
	 * @param Jeux jeu
	 * @return Jeuxdto jeuDTO
	 */
	List<JeuxDTO> findAllDTO();

	/**
	 * Ajoute un nouveau jeux à partir d'une DTO
	 * @param Jeux jeudto
	 * @return JeuxDTO jeuDTO
	 */
	JeuxDTO addJeux(JeuxDTO jeu);

	/**
	 * Supprime un jeu
	 * @param id
	 * @return
	 */
	String deleteJeux(Long id);
}
