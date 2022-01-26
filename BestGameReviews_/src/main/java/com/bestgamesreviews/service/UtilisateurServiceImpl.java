package com.bestgamesreviews.service;

import java.util.List;
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
import com.bestgamesreviews.exception.UtilisateurException;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	private final UtilisateurDAO userRepository;
	private final BCryptPasswordEncoder passwordEncoders;

	public UtilisateurServiceImpl(UtilisateurDAO userRepository) {

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

	@Override
	public Utilisateur persiste(Utilisateur utilisateur) throws UtilisateurException {
		if (!"".equals(utilisateur.getEmail().trim()) && utilisateur.getEmail() != null
				&& !"".equals(utilisateur.getMotDePasse().trim()) && utilisateur.getMotDePasse() != null
				&& !"".equals(utilisateur.getPseudo().trim()) && utilisateur.getPseudo() != null) {
			this.userRepository.save(utilisateur);
		} else {
			throw new UtilisateurException(
					"L'utilisateur que vous tentez de persister ne contient pas assez de paramètre!");
		}
		return null;
	}

	@Override
	public Utilisateur getByEmail(Utilisateur utilisateur) {
		Utilisateur user;
		List<Utilisateur> user1 = userRepository.findByEmail(utilisateur.getEmail());
		if (user1.size() > 0) {
			user = user1.get(0);
			if (user != null && !user.getEmail().trim().equals("") && user.getEmail() != null) {
				utilisateur = user;
			}
		}
		return utilisateur;
	}

}
