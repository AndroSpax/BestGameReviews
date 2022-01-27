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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestgamesreviews.dto.AvisDTO;
import com.bestgamesreviews.entity.Avis;
import com.bestgamesreviews.service.AvisService;
import com.bestgamesreviews.service.AvisServiceImpl;

/**
 * @author Marielle Machael Rudolph
 *
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class AvisController {

	@Autowired
	AvisService avisService = new AvisServiceImpl();

	public AvisController() {
	}

	@GetMapping(value = "/liste-avis")
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
		return ResponseEntity.status(200).body(response);
	}

	
	@GetMapping(value = "/liste-avis-dto")
	public List<AvisDTO> obtenirAvisDTO() {
	
	 return avisService.findAllDTO();
	}
	

	@PostMapping("/ajouter-avis")
	public ResponseEntity<?> ajouterAvis(@RequestBody Avis avis) {
		Avis response = avisService.addAvis(avis);
		return ResponseEntity.status(201).body(response);
	}

	@PutMapping("/valider-avis")
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

	@DeleteMapping("/supprimer-avis/{id}")
	public ResponseEntity<?> supprimerAvis(@PathVariable Long id) {
		String response = avisService.deleteAvis(id);
		return ResponseEntity.status(200).body(response);
	}

}
