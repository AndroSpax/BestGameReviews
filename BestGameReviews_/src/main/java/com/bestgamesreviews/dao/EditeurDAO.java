package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Editeur;

/**
 * Interface de persistence des entités Editeur 
 * @author Marielle Michael Rudolph 
 *
 */
public interface EditeurDAO extends JpaRepository<Editeur, Long> {

}
