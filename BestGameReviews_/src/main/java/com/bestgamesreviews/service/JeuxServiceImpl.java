package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.JeuxDAO;
import com.bestgamesreviews.dto.AvisDTO;
import com.bestgamesreviews.dto.JeuxDTO;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.exception.JeuxException;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Implémentation du service JeuxService
 * 
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class JeuxServiceImpl implements JeuxService {

	@Autowired
	JeuxDAO jeuDao;

	@Override
	public List<Jeux> findAll() {
		try {
			return jeuDao.findAll();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	/**
	 * Renvoie une lite de jeux sous forme de DTO 
	 * @return List<JeuxDTO> jeudto
	 */

	@Override
	public List<JeuxDTO> findAllDTO() {
		List<JeuxDTO> jeudto = new ArrayList<>();
		List<Jeux> listJeux  = jeuDao.findAll();
		
		listJeux.forEach(e -> {
		
			jeudto.add(transformeDto(e));
				});
		return jeudto ;
	}
	

	@Override
	public Jeux persiste(Jeux jeux) throws JeuxException {
		if (!"".equals(jeux.getNom().trim()) && jeux.getNom() != null) {
			jeux = jeuDao.save(jeux);
		} else {
			throw new JeuxException("Le Jeu que vous tentez de persister ne contient pas de nom!");
		}
		return jeux;
	}
	
	
	
	
	@Override
	public String deleteAvis(Long id) {
		try {
			jeuDao.deleteById(id);
			return "Avis " + id + " supprimée";
		} catch (Exception e) {
			return "Supression de l'avis " + id + " impossible ";
		}
	}
	
	/**
	 * Permet de transformer un objet Jeux en JeuxDTO
	 * @param Jeux jeu
	 * @return Jeuxdto jeuDTO
	 */
	public JeuxDTO transformeDto(Jeux jeu) {
		
		StringBuilder sb = new StringBuilder();
		jeu.getListePlateforme().forEach(plat ->sb.append(plat.getNom()+ ","));
		
		return new JeuxDTO(jeu.getId(),
				jeu.getNom(),
				jeu.getEditeur().getNom(),
				jeu.getDateSortie(),
				jeu.getDescription(),
				jeu.getGenre().getNom(),
				jeu.getImage(),
				jeu.getClassification().getNom(),
				sb.toString(),
				jeu.getModeleEconomique().getNom());
	}
}
