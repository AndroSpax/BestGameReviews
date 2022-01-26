/**
 * 
 */
package com.bestgamesreviews.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestgamesreviews.configuration.AuthoritiesConstants;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.service.AvisService;
import com.bestgamesreviews.service.AvisServiceImpl;

/**
 * @author Marielle Machael Rudolph
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = { "x-auth-token", "x-requested-with", "x-xsrf-token" })
@RestController
@RequestMapping("api/avis")
public class AvisController {

	@Autowired
	AvisService avisService = new AvisServiceImpl();

	public AvisController() {
	}

	@RolesAllowed({ "USER", "ADMIN" })
	@GetMapping(value = "/liste")
	public ResponseEntity<?> obtenirAvis() {
		Map<String, Avis> response = new HashMap<>();
		try {
			for (Avis avis : avisService.findAll()) {
				response.put(String.valueOf(avis.getId()), avis);
			}
		} catch (Exception e) {
			response.put("error", null);
			return ResponseEntity.status(409).body(response);
		}
		return ResponseEntity.status(201).body(response);
	}

	@RolesAllowed("USER")
	@PostMapping("/ajouter")
	public ResponseEntity<?> ajouterAvis(@RequestBody Avis avis) {
		Avis response = avisService.addAvis(avis);
		return ResponseEntity.status(200).body(response);
	}

	@RolesAllowed("ADMIN")
	@PutMapping("/valider")
	public ResponseEntity<?> validerAvis(@RequestBody Avis avis) {
		Map<String, Avis> response = new HashMap<>();
		try {
			System.out.println(" it works ");
			response.put("sucess", avisService.validateAvis(avis));
		} catch (Exception e) {
			response.put("echec", null);
		}
		return ResponseEntity.status(200).body(response);
	}

	@RolesAllowed("ADMIN")
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<?> supprimerAvis(@PathVariable Long id) {
		String response = avisService.deleteAvis(id);
		return ResponseEntity.status(200).body(response);
	}
}
