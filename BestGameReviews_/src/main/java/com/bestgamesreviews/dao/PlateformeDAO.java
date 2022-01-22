package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Plateforme;

/**
 * Interface de persistence des entités Plateforme
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
public interface PlateformeDAO extends JpaRepository<Plateforme, Long> {

}
