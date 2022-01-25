package com.bestgamesreviews.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.JoueurDAO;
import com.bestgamesreviews.entity.Joueur;

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
	public Joueur addJoueur(Joueur joueur) {

		try {
			return joueurDAO.save(joueur);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Joueur findJoueur(String pseudo, String password) {

		if (!joueurDAO.findAll().isEmpty()) {
			for (Joueur j : joueurDAO.findAll()) {
				if (j.getPseudo().equals(pseudo)) {
					return j;
				}
			}
		}
		return null;
	}

	@Override
	public Optional<Joueur> find(Long id) {

		Optional<Joueur> joueur = joueurDAO.findById(id);
		if (!joueur.equals(null)) {
			return joueur;
		}
		return null;
	}
}
