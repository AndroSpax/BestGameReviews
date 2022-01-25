package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bestgamesreviews.dao.PlateformeDAO;
import com.bestgamesreviews.entity.Plateforme;

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

}
