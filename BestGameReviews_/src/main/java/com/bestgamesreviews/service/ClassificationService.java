package com.bestgamesreviews.service;

import com.bestgamesreviews.entity.Classification;
import com.bestgamesreviews.exception.ClassificationException;

/**
 * Interface de service des entités Classification
 * @author Marielle Michael Rudolph
 *
 */
public interface ClassificationService {

	/**
	 * 
	 * @param classification
	 * @return
	 * @throws ClassificationException
	 */
	Classification persiste(Classification classification) throws ClassificationException;
}
