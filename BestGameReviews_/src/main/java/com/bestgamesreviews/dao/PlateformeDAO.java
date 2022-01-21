package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Plateforme;

/**
 * Interface de persistence des entités Plateforme
 * @author Marielle Michael Rudolph 
 *
 */
public interface PlateformeDAO extends JpaRepository<Plateforme, Long> {

}
