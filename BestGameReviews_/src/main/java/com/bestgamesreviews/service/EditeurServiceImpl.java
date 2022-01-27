package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.EditeurDAO;
import com.bestgamesreviews.entity.Editeur;
import com.bestgamesreviews.exception.EditeurException;

/**
 * Implémentation de EditeurService
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class EditeurServiceImpl implements EditeurService {
	@Autowired
	EditeurDAO editeurDAO;

	@Override
	public Editeur persiste(Editeur editeur) throws EditeurException {
		if (!"".equals(editeur.getNom().trim()) && editeur.getNom() !=null) {
			editeurDAO.save(editeur);
		} else {
			throw new EditeurException("L'objet editeur que vous tentez de persister ne contient pas de nom!");
		}
		return editeur;
	}

	@Override
	public List<Editeur> getAll() {		
		return editeurDAO.findAll();
	}
	
	
}
