package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Plateforme;

/**
 * Interface de persistence des entités Plateforme
 * 
 * @author Marielle Michael Rudolph
 *
 */
@Repository
@RepositoryRestResource(exported = true)
public interface PlateformeDAO extends JpaRepository<Plateforme, Long> {

	/**
	 * Trouver une plateforme par son nom
	 * 
	 * @param String nomPlateforme
	 * @return Plateforme plateforme
	 */
	Plateforme findByNom(String nomPlateforme);

}
