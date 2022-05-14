package com.card.backend.repository;

import com.card.backend.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CardRepository extends JpaRepository<CardEntity, String> {
}
