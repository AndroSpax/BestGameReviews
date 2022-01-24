/**
 *
 */
package com.bestgamesreviews.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestgamesreviews.entity.Joueur;
import com.bestgamesreviews.entity.Utilisateur;
import com.bestgamesreviews.service.JoueurService;
import com.bestgamesreviews.service.JoueurServiceImpl;
import com.bestgamesreviews.service.ModerateurService;
import com.bestgamesreviews.service.ModerateurServiceImpl;

/**
 * Controller pour gérer tous les intéraction des utilisateurs
 * 
 * @author Marielle Machael Rudolph
 *
 */
@RestController
public class UserController {

	@Autowired
	JoueurService joueurService = new JoueurServiceImpl();
	@Autowired
	ModerateurService moderateurService = new ModerateurServiceImpl();

	public UserController() {

	}

	/**
	 * Permet à un joueur de s'inscrire
	 * 
	 * @param Joueur joueur
	 * @return ResponseEntity <Map<String, Joueur>>
	 */
	@PostMapping("/api/inscription/")
	public ResponseEntity<?> inscriptionJoueur(@RequestBody Joueur joueur) {

		Map<String, Joueur> response = new HashMap<>();

		try {
			Joueur j = joueurService.addJoueur(joueur);
			if (j != (null)) {
				response.put("joueur", j);
			} else {
				response.put("Opération inpossible", null);
			}

		} catch (Exception e) {
			response.put("error", null);
			return ResponseEntity.status(409).body(response);
		}
		if (response.containsKey("Opération inpossible")) {
			return ResponseEntity.status(400).body(response);
		}
		return ResponseEntity.status(201).body(response);
	}

	/**
	 * Permet à un utilisateur de se connecter avec un pseudo / mot de passe !
	 * 
	 * @param Map<String, String> credentials
	 * @return ResponseEntity <Map<String, Joueur>>
	 */
	@PostMapping("/api/connexion/")
	public ResponseEntity<?> connexion(@RequestBody Map<String, String> credentials) {

		Map<String, Optional<?>> response = new HashMap<>();
		try {
			Utilisateur moderateur = moderateurService.findModerateur(credentials.get("pseudo"),
					credentials.get("motDePasse"));
			if (moderateur.equals(null)) {
				Utilisateur joueur = joueurService.findJoueur(credentials.get("pseudo"), credentials.get("motDePasse"));
				if (joueur != null) {
					response.put("Sucess", Optional.of(joueur));
				}
			} else if (!moderateur.equals(null)) {
				response.put("Sucess", Optional.of(moderateur));
			}
			response.put("nothing was found", null);
		} catch (SQLException e) {
			e.printStackTrace();
			response.put("error", null);
			return ResponseEntity.status(409).body(response);
		}
		return ResponseEntity.status(201).body(response);
	}

}
