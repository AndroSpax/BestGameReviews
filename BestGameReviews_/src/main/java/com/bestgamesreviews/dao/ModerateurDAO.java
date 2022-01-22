package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Moderateur;

/**
 * Interface de persistence des entités Moderateur
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
public interface ModerateurDAO extends JpaRepository<Moderateur, Long> {

}
