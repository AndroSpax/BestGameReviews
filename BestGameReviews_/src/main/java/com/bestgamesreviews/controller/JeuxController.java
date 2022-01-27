/**
 * 
 */
package com.bestgamesreviews.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestgamesreviews.dto.JeuxDTO;
import com.bestgamesreviews.entity.Jeux;
import com.bestgamesreviews.entity.Plateforme;
import com.bestgamesreviews.exception.JeuxException;
import com.bestgamesreviews.service.JeuxService;
import com.bestgamesreviews.service.JeuxServiceImpl;
import com.bestgamesreviews.service.PlateformeServiceImpl;

/**
 * @author Marielle Machael Rudolph
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = { "x-auth-token", "x-requested-with", "x-xsrf-token" })
@RestController
@RequestMapping("api")
public class JeuxController {

	@Autowired
	private JeuxService jeuxService = new JeuxServiceImpl();

	private final PlateformeServiceImpl plateformeServiceImpl;

	@Autowired
	public JeuxController(PlateformeServiceImpl plateformeServiceImpl) {
		this.plateformeServiceImpl = plateformeServiceImpl;
	}

	/**
	 * Renvoie la jeux des jeux présent en base de donnée
	 * 
	 * @return ResponseEntity<status>.body(Map<String id, Jeux jeu)
	 */
	@Deprecated(forRemoval = true)
	@GetMapping("/liste-jeux")
	public ResponseEntity<?> obtenirJeux() {
		Map<String, Jeux> response = new HashMap<>();
		try {
			for (Jeux jeu : jeuxService.findAll()) {
				response.put(String.valueOf(jeu.getId()), jeu);
			}
		} catch (Exception e) {

			response.put("error", null);
			return ResponseEntity.status(409).body(response);
		}
		return ResponseEntity.status(200).body(response);
	}

	/**
	 * Renvoie les jeux présent en base de donnée sous forme dto
	 *
	 * @return List<JeuxDTO>
	 */
	@GetMapping("/liste-jeux-dto")
	public List<JeuxDTO> obtenirJeuxDTO() {
		return jeuxService.findAllDTO();
	}

	@Deprecated(forRemoval = true)
	@PostMapping("ajouter-jeux")
	public ResponseEntity<?> ajouterJeux(@RequestBody Jeux jeu) {
		Jeux response = null;
		try {
			response = jeuxService.persiste(jeu);
		} catch (JeuxException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(201).body(response);
	}

	/**
	 * Ajoute un jeu à partir d'une DTO
	 * 
	 * @param JeuxDTO jeuDto
	 * @return JeuxDTO jeuDto
	 */
	
	@PostMapping("/ajouter-jeux-dto")
	public JeuxDTO ajouterJeuxDTO(@RequestBody JeuxDTO jeu) {
		try {
			return jeuxService.addJeux(jeu);	
		} catch (Exception e) {
			e.printStackTrace(); //TODO : to remove
			return null;
		}
	}

	/**
	 * Permet de supprimer un jeu
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("supprimer-jeux/{id}")
	public ResponseEntity<?> supprimerJeux(@PathVariable Long id) {
		String response = jeuxService.deleteAvis(id);
		return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/plateforme")
	public List<Plateforme> plateforme() {
		return plateformeServiceImpl.getAll();
	}
}