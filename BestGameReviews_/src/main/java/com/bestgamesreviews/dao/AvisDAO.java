package com.bestgamesreviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Avis;

public interface AvisDAO extends JpaRepository<Avis, Long> {

}
