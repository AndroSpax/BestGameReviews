/**
 * 
 */
package com.bestgamesreviews.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bestgamesreviews.entity.Utilisateur;

/**
 * @author Marielle Machael Rudolph
 *
 */
public interface IUtilisateurService {
	 Utilisateur loadUserByUsername(String username)
	            throws UsernameNotFoundException;
	 public void createUser(Utilisateur  userCreateRequest);
}
