package com.bestgamesreviews.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.ModerateurDAO;
import com.bestgamesreviews.entity.Moderateur;

@Service
public class ModerateurServiceImpl implements ModerateurService {

	@Autowired
	ModerateurDAO moderateurDAO;

	@Override
	public Moderateur addModerateur(Moderateur moderateur) {
		return moderateurDAO.save(moderateur);
	}

	@Override
	public Moderateur findModerateur(String pseudo, String password) {
		if (!moderateurDAO.findAll().isEmpty()) {
			for (Moderateur m : moderateurDAO.findAll()) {
				
				if (m.getPseudo().equals(pseudo)) {
					return m;
				}
			}
		}
		return null;
	}

	@Override
	public Optional<Moderateur> find(Long id) {

		Optional<Moderateur> moderateur = moderateurDAO.findById(id);
		if (moderateur != null) {
			return moderateur;
		}
		return null;
	}

}
