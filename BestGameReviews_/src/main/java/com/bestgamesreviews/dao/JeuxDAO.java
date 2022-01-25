package com.bestgamesreviews.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bestgamesreviews.entity.Jeux;

/**
 * Interface de persistence des entités Jeux
 * @author Marielle Michael Rudolph 
 *
 */
@Repository
@RepositoryRestResource(exported = true)
public interface JeuxDAO extends JpaRepository<Jeux, Long> {

}
