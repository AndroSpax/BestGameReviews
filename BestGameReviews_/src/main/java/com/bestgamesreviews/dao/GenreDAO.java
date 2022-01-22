package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Genre;

/**
 * Interface de persistence des entités Genre
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
public interface GenreDAO extends JpaRepository<Genre, Long> {

}
