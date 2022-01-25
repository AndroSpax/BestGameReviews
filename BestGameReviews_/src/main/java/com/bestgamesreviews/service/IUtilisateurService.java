/**
 * 
 */
package com.bestgamesreviews.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bestgamesreviews.entity.Utilisateur;
import com.bestgamesreviews.exception.UtilisateurException;

/**
 * @author Marielle Machael Rudolph
 *
 */
public interface IUtilisateurService {
	/**
	 * 
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	 Utilisateur loadUserByUsername(String username)throws UsernameNotFoundException;
	 
	 /**
	  * 
	  * @param userCreateRequest utilisateur
	  */
	 public void createUser(Utilisateur  userCreateRequest);
	 
	 /**
	  * Créer un utilisateur ne base de données
	  * @param utilisateur
	  * @return
	 * @throws UtilisateurException 
	  */
	 Utilisateur persiste(Utilisateur utilisateur) throws UtilisateurException;
}
