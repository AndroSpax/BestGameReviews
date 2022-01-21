package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Genre;

/**
 * Interface de persistence des entités Genre
 * @author Marielle Michael Rudolph 
 *
 */
public interface GenreDAO extends JpaRepository<Genre, Long> {

}
