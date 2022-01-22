/**
 *
 */
package com.bestgamesreviews.controller;

import com.bestgamesreviews.entity.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.bestgamesreviews.service.JoueurService;
import com.bestgamesreviews.service.JoueurServiceImpl;

/**
 * @author Marielle Machael Rudolph 
 *
 */
@RestController
public class UserController {

    @Autowired
    JoueurService joueurService = new JoueurServiceImpl();

    public UserController() {
        // TODO Auto-generated constructor stub
    }

    /*TODO : Exemple requête JSON
     {
  "id":"",
  "pseudo": "Jean Luc Pi",
  "motDePasse": "mdppp",
  "email": "jl@picard.frr",
  "dateDenaissance": ""
	}
     */
    @PostMapping("/api/inscription/")
    public ResponseEntity<?> inscriptionJoueur(@RequestBody Joueur joueur){
    	
        Map<String, Joueur> response = new HashMap<>();
        
        try {
        	;
            response.put("joueur", joueurService.add(joueur)); //joueur
        } catch (Exception e) {
            response.put("error", null);
            return ResponseEntity.status(409).body(response);
        }
        return  ResponseEntity.status(201).body(response);
    }
}
