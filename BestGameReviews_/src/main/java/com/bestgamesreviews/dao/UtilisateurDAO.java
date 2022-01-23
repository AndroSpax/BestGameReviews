package com.bestgamesreviews.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bestgamesreviews.entity.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long>{
	
	/**
	 * Methodde qui prend un 
	 * @param username
	 * @return
	 */
	 @Query(" select u from Utilisateur u " +
	            " where u.pseudo = ?1"
	            + "or u.email = ?1")
	    Optional<Utilisateur> findByUsername(String username);
}
