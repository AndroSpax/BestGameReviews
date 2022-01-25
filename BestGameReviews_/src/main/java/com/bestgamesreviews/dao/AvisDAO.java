package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Avis;


/**
 * Interface de persistence des entités Avis 
 * @author Marielle Michael Rudolph 
 * 
 */
@RepositoryRestResource(exported = true)
public interface AvisDAO extends JpaRepository<Avis, Long> {

}
