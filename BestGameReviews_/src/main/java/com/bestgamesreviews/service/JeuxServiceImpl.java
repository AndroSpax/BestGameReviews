package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.JeuxDAO;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.exception.JeuxException;
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
	public Jeux persiste(Jeux jeux) throws JeuxException {
		if (!"".equals(jeux.getNom().trim()) && jeux.getNom() != null) {
			jeux = jeuDao.save(jeux);
		} else {
			throw new JeuxException("Le Jeu que vous tentez de persister ne contient pas de nom!");
		}
		return jeux;
	}

	@Override
	public List<Jeux> findAll() {
		try {
			return jeuDao.findAll();
		} catch (Exception e) {
			return Collections.emptyList();
		}
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
}
