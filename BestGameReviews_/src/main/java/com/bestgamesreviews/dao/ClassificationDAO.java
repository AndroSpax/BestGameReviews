package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Classification;

/**
 * Interface de persistence des entités Classification
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
public interface ClassificationDAO extends JpaRepository<Classification, Long> {

}
