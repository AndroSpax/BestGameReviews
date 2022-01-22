package com.bestgamesreviews.service;

import com.bestgamesreviews.entity.Joueur;

/**
 * Interface de service des entités Joueur
 * @author Marielle Michael Rudolph
 *
 */
public interface JoueurService {

    Joueur add(Joueur joueur);

    Joueur find(Long id);
}
