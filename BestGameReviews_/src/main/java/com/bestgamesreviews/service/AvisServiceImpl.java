package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.AvisDAO;
import com.bestgamesreviews.entity.Avis;

@Service
public class AvisServiceImpl implements AvisService {

	@Autowired
	AvisDAO avisDAO;

	@Override
	public List<Avis> findAll() {
		return avisDAO.findAll();
	}

	@Override
	public Avis addAvis(Avis avis) {
		// TODO : vérifier que il y a pas de doublon
		return avisDAO.save(avis);
	}

	@Override
	public Avis validateAvis(Avis avis) {
		// TODO : doit vérifier que l'objet n'a pas d'attribut null
		return avisDAO.save(avis);
	}

	@Override
	public String deleteAvis(Long id) {
		avisDAO.deleteById(id);
		return "Avis " + id + " supprimée";
	}

}
