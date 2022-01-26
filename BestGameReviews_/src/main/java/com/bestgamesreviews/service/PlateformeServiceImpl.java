package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bestgamesreviews.dao.PlateformeDAO;
import com.bestgamesreviews.entity.Plateforme;
import com.bestgamesreviews.exception.PlateformeException;

/**
 * Implémentation de PlateformeService
 * @author Marielle Michael Rudolph
 *
 */
@Service
@Transactional
public class PlateformeServiceImpl implements PlateformeService {

	
	private final PlateformeDAO dao;
	
	public PlateformeServiceImpl(PlateformeDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Plateforme> getAll() {
	return dao.findAll();
	}

	@Override
	public Plateforme persiste(Plateforme plateforme) throws PlateformeException {
		if (!"".equals(plateforme.getNom().trim()) && plateforme.getNom().trim() != null) {
			plateforme = dao.save(plateforme);
		} else {
			throw new PlateformeException("La plateforme que vous tentez de persister ne contient pa de nom!");
		}
		return plateforme;
	}

}
