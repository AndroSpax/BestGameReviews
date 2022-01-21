package com.bestgamesreviews.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bestgamesreviews.entity.Jeux;

public interface JeuxDAO extends JpaRepository<Jeux, Long> {

}
