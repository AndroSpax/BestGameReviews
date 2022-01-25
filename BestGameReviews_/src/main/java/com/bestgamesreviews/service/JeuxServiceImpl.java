package com.bestgamesreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.JeuxDAO;
import com.bestgamesreviews.entity.Jeux;
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
	JeuxDAO dao;

	@Override
	public Jeux persiste(Jeux jeux) throws JeuxException {
		if (!"".equals(jeux.getNom().trim()) && jeux.getNom() != null) {
			jeux = dao.save(jeux);
		} else {
			throw new JeuxException("Le Jeu que vous tentez de persister ne contient pas de nom!");
		}
		return jeux;
	}

}
