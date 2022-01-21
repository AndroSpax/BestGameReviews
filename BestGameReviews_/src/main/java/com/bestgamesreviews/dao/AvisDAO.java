package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Avis;


/**
 * Interface de persistence des entités Avis 
 * @author Marielle Michael Rudolph 
 * 
 */
public interface AvisDAO extends JpaRepository<Avis, Long> {

}
