package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Genre;

/**
 * Interface de persistence des entités Genre
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
@RepositoryRestResource(exported = true)
public interface GenreDAO extends JpaRepository<Genre, Long> {

	/**
	 * Retrouve un genre par rapport à son nom
	 * @param String genre
	 * @return Genre genre
	 */
	Genre findByNom(String genre);

}
