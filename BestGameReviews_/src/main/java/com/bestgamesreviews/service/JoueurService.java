package com.bestgamesreviews.service;



import java.util.Optional;

import com.bestgamesreviews.entity.Joueur;

/**
 * Interface de service des entités Joueur
 * @author Marielle Michael Rudolph
 *
 */

public interface JoueurService {

    Joueur add(Joueur joueur);

    Optional<Joueur> find(Long id);
}
