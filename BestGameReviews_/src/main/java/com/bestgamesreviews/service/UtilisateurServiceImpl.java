package com.bestgamesreviews.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.UtilisateurDAO;
import com.bestgamesreviews.entity.Joueur;
import com.bestgamesreviews.entity.Utilisateur;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService{

	private final UtilisateurDAO userRepository;
    private final BCryptPasswordEncoder passwordEncoders;
	
    @Autowired
	public UtilisateurServiceImpl(UtilisateurDAO userRepository) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoders = new BCryptPasswordEncoder();
	}

	@Override
	public Utilisateur loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);

	}

	@Override
	public void createUser(Utilisateur userCreateRequest) {
		  Utilisateur user = new Joueur();
	        Optional<Utilisateur> byUsername = userRepository.findByUsername(userCreateRequest.getPseudo());
	        if (byUsername.isPresent()) {
	            throw new RuntimeException("User already registered. Please use different username.");
	        }
	        user.setPseudo(userCreateRequest.getPseudo());
	        user.setMotDePasse(passwordEncoders.encode(userCreateRequest.getMotDePasse()));
	        userRepository.save(user);
	}

}
