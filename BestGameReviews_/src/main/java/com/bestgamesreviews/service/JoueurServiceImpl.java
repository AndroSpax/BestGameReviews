package com.bestgamesreviews.service;

import com.bestgamesreviews.entity.Joueur;
import com.bestgamesreviews.dao.JoueurDAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de JoeurService
 * 
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class JoueurServiceImpl implements JoueurService {

	@Autowired
	JoueurDAO joueurDAO;

	@Override
	public Joueur add(Joueur joueur) {
		return joueurDAO.save(joueur);
	}

	@Override
	public Optional<Joueur> find (Long id) {
		Optional<Joueur> joueur = joueurDAO.findById(id);
		if(joueur != null ) {
			return joueur;
		}
		return null;
	}

}
