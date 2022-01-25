/**
 * 
 */
package com.bestgamesreviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestgamesreviews.entity.Plateforme;
import com.bestgamesreviews.service.PlateformeServiceImpl;

/**
 * @author Marielle Machael Rudolph 
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600,
allowedHeaders={"x-auth-token", "x-requested-with", "x-xsrf-token"})
@RestController
@RequestMapping("api/jeux")
public class JeuxController {

	private final PlateformeServiceImpl plateformeServiceImpl; 
	@Autowired
	public JeuxController(PlateformeServiceImpl plateformeServiceImpl) {
		this.plateformeServiceImpl = plateformeServiceImpl;
	}
	
	@GetMapping("/plateforme")
	public List<Plateforme> plateforme() {
		return plateformeServiceImpl.getAll();
	}
}
