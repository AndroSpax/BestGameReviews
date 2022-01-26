package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.AvisDAO;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.exception.AvisException;

@Service
public class AvisServiceImpl implements AvisService {

	@Autowired
	AvisDAO avisDAO;

	@Override
	public List<Avis> findAll() {
		try {
			return avisDAO.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Avis addAvis(Avis avis) {
		try {
			return avisDAO.save(avis);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Avis validateAvis(Avis avis) {
		try {
			if (avisDAO.findById(avis.getId()) != null) {
				return avisDAO.save(avis);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String deleteAvis(Long id) {
		try {
			avisDAO.deleteById(id);
			return "Avis " + id + " supprimée";
		} catch (Exception e) {
			return "Supression de l'avis " + id + " impossible ";
		}
	}

	@Override
	public Avis persiste(Avis avis) throws AvisException {
		if (avis.getJoueur() != null) {
			avis = avisDAO.save(avis);
		}else {
			throw new AvisException("Cette avis n'est associé à aucun joueur");
		}
		return avis;
	}
	
}