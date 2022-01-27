/**
 * 
 */
package com.bestgamesreviews.service;

import java.util.List;

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
	 * Charge tous les utilisateurs
	 * @return List<Utilisateurs> 
	 */
	List<Utilisateur> getAllUsers();
	
	/**
	 * 
	 * @param username
	 * @return Utilisateur
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
	 
	 /**
	  * reorne un utilisateur en fonction de sont email
	  * @param utilisateur
	  * @return
	  */
	 Utilisateur getByEmail(Utilisateur utilisateur);
}
