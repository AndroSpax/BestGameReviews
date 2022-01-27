package com.bestgamesreviews.service;

import java.util.List;

import com.bestgamesreviews.entity.Genre;
import com.bestgamesreviews.exception.GenreException;

/**
 * Interface de service des entités Genre
 * @author Marielle Michael Rudolph
 *
 */
public interface GenreService {

	/**
	 * persiste un genre en base si ce dernier contient bien un nom
	 * il retourne un Objet Genre
	 * @param genre
	 * @return
	 * @throws GenreException 
	 */
	Genre persiste(Genre genre) throws GenreException;
	
	/**
	 * Retourne tous les genres
	 * @return
	 */
	List<Genre> getAll();
}
