package com.bestgamesreviews.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.ClassificationDAO;
import com.bestgamesreviews.dao.EditeurDAO;
import com.bestgamesreviews.dao.GenreDAO;
import com.bestgamesreviews.dao.JeuxDAO;
import com.bestgamesreviews.dao.ModeleEconomiqueDAO;
import com.bestgamesreviews.dao.PlateformeDAO;
import com.bestgamesreviews.dto.JeuxDTO;
import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.entity.Plateforme;
import com.bestgamesreviews.exception.JeuxException;

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
	//DAO nécessaire dans cette fonction 
	@Autowired
	ClassificationDAO clDao;
	@Autowired
	GenreDAO genreDAO;
	@Autowired
	EditeurDAO editeurDAO;
	@Autowired
	ModeleEconomiqueDAO meDAO;
	@Autowired
	PlateformeDAO plaDAO;

	@Override
	public List<Jeux> findAll() {
		try {
			return jeuDao.findAll();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
	
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
	
	public JeuxDTO transformeDto(Jeux jeu) {
		
		StringBuilder sb = new StringBuilder();
		jeu.getListePlateforme().forEach(plat -> sb.append(plat.getNom()+ ","));
		
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

	@Override
	public JeuxDTO addJeux(JeuxDTO jeu) {
		
		//List des plateforme 
		List<Plateforme> plateformeJeux = new ArrayList<>();
		//pour récupérer les noms des plateformes
		StringBuilder platName  = new StringBuilder();
		for(char ch : jeu.getPlateforme().toCharArray()) {
			if(ch == ',') {
				plateformeJeux.add(plaDAO.findByNom(platName.toString()));
				platName.setLength(0);;
			}
		platName.append(ch);
		}
		//  /!\ TODO : trouver le moyen d'enregistrer le dernier mot /!\
		//pour ajouter le dernier Plateforme
		plateformeJeux.add(plaDAO.findByNom(platName.toString()));
		
		return transformeDto( jeuDao.save( new Jeux(
				jeu.getNom(),
				jeu.getDescription(),
				jeu.getDateDeSortie(),
				jeu.getImage(),
				clDao.findByNom(jeu.getClassification()),
				genreDAO.findByNom(jeu.getGenre()),
				editeurDAO.findByNom(jeu.getEditeur()),
				plateformeJeux,
				meDAO.findByNom(jeu.getModeleEconomique())
			)));
		
	}
}
