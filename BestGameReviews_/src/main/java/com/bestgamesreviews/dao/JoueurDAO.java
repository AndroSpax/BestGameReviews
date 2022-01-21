package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Joueur;

/**
 * Interface de persistence des entités Joueur
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
public interface JoueurDAO extends JpaRepository<Joueur, Long> {

}
