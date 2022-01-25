package com.bestgamesreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.ClassificationDAO;
import com.bestgamesreviews.entity.Classification;
import com.bestgamesreviews.exception.ClassificationException;

/**
 * Implémentation de ClassificationService
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {

	private ClassificationDAO classificationDAO;
	public ClassificationServiceImpl(ClassificationDAO classificationDAO) {
		this.classificationDAO = classificationDAO;
	}

	@Override
	public Classification persiste(Classification classification) throws ClassificationException {
		if(!classification.getNom().trim().equals("") && classification.getNom() != null) {
			classification = classificationDAO.save(classification);
		}else {
			throw new ClassificationException("La classification que vous voulez persister ne posséde pas nom!");
		}
		return classification;
	}

}
