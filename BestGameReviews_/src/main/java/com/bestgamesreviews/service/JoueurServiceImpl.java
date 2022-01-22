package com.bestgamesreviews.service;

import com.bestgamesreviews.entity.Joueur;
import com.bestgamesreviews.dao.JoueurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de JoeurService
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class JoueurServiceImpl implements JoueurService {


    JoueurDAO joueurDAO;


    @Override
    public Joueur add(Joueur joueur) {
        joueurDAO.save(joueur);
        return joueur;
    }

//    @Override
//    public Joueur find(Long id) {
//        return null;
//    }

    @Override
    public Joueur find(Long id) {
        return joueurDAO.findById(id);
    }


}
