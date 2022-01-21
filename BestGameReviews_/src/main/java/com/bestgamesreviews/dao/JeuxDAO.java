package com.bestgamesreviews.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Jeux;

/**
 * Interface de persistence des entités Jeux
 * @author Marielle Michael Rudolph 
 *
 */
public interface JeuxDAO extends JpaRepository<Jeux, Long> {

}
