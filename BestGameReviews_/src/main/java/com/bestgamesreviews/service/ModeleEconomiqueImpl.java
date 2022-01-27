package com.bestgamesreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestgamesreviews.dao.ModeleEconomiqueDAO;
import com.bestgamesreviews.entity.ModeleEconomique;
import com.bestgamesreviews.exception.ModeleEconomiqueException;

/**
 * Implématation de ModeleEcconomiqueService
 * 
 * @author Marielle Michael Rudolph
 *
 */
@Service
public class ModeleEconomiqueImpl implements ModeleEconomiqueService {

	@Autowired
	ModeleEconomiqueDAO economiqueDAO;

	@Override
	public ModeleEconomique persiste(ModeleEconomique modeleEconomique) throws ModeleEconomiqueException {
		if (!"".equals(modeleEconomique.getNom().trim())) {
			economiqueDAO.save(modeleEconomique);
		} else {
			throw new ModeleEconomiqueException(
					"La modeleEconomique que vous tentez de persister ne contient pa de nom!");
		}
		return null;
	}

	@Override
	public List<ModeleEconomique> getAll() {
		return economiqueDAO.findAll();
	}

}
