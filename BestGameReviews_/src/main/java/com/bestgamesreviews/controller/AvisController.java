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
import com.bestgamesreviews.exception.AvisException;
import com.bestgamesreviews.service.AvisService;
import com.bestgamesreviews.service.AvisServiceImpl;

/**
 * Controller lié à aux Avis
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

	@Deprecated(forRemoval = true)
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

	/**
	 * Renvoie la liste des Avis
	 * @return
	 */
	@GetMapping(value = "/liste-avis-dto")
	public List<AvisDTO> obtenirAvisDTO() {
		Map<String, Object> response = new HashMap<>();
		return avisService.findAllDTO();
	}

	/**
	 * Ajouter un avis
	 * 
	 * @param avis
	 * @return
	 */
	@PostMapping("/ajouter-avis-dto")
	public AvisDTO ajouterAvisDTO(@RequestBody AvisDTO avisDto) {
		return avisService.addAvis(avisDto);
	}
	
	/**
	 * Ajouter un avis (Deprecated)
	 * 
	 * @param avis
	 * @return 
	 */
	@Deprecated(forRemoval = true)
	@PostMapping("/ajouter-avis")
	public ResponseEntity<?> persiste(@RequestBody Avis avis) {
		Avis response = null;
		try {
			response = avisService.persiste(avis);
		} catch (AvisException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(201).body(response);
	}

	/**
	 * Permet de valider un avis
	 * 
	 * @param id_Avis
	 * @param id_Moderateur
	 * @return
	 */
	@Deprecated(forRemoval = true)
	@PutMapping("/valider-avis-old")
	public ResponseEntity<?> validerAvis(@RequestBody Avis avis) {
		Map<String, Avis> response = new HashMap<>();
		try {
			response.put("sucess", avisService.validateAvis(avis));
		} catch (Exception e) {
			response.put("echec", null);
		}
		return ResponseEntity.status(200).body(response);
	}

	/**
	 * Permet de valider un avis
	 * 
	 * @param id_Avis
	 * @param id_Moderateur
	 * @return
	 */
	@PostMapping("/valider-avis")
	public AvisDTO validerAvis(@PathVariable Long id_Avis, Long id_Moderateur) {
		return avisService.modererAvis(id_Avis, id_Moderateur);
	}

	/**
	 * Supprimer un avis
	 * @param id
	 * @return
	 */
	@DeleteMapping("/supprimer-avis/{id}")
	public ResponseEntity<?> supprimerAvis(@PathVariable Long id) {
		String response = avisService.deleteAvis(id);
		return ResponseEntity.status(200).body(response);
	}
}
