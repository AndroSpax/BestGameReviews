package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Classification;

/**
 * Interface de persistence des entités Classification
 * @author Marielle Michael Rudolph 
 *
 */
public interface ClassificationDAO extends JpaRepository<Classification, Long> {

}
