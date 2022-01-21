package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Moderateur;

/**
 * Interface de persistence des entités Moderateur
 * @author Marielle Michael Rudolph 
 *
 */
public interface ModerateurDAO extends JpaRepository<Moderateur, Long> {

}
