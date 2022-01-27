package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.GenreDAO;
import com.bestgamesreviews.entity.Genre;
import com.bestgamesreviews.exception.GenreException;

/**
 * Implémentation de GenreService
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class GenreServiceImpl implements GenreService{
	@Autowired
	GenreDAO genreDAO;

	@Override
	public Genre persiste(Genre genre) throws GenreException {
		if (!"".equals(genre.getNom().trim() )&& genre.getNom() != null) {
			genreDAO.save(genre);
		} else {
			throw new GenreException("Le genre que vous tentez de persister ne contient pas de nom!");
		}
		return null;
	}

	@Override
	public List<Genre> getAll() {
		return genreDAO.findAll() ;
	}

}
