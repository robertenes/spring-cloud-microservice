package com.card.backend.service;

import com.card.backend.model.dto.CardRequestDTO;
import com.card.backend.model.dto.CardResponseDTO;

import java.io.FileNotFoundException;
import java.util.List;

public interface CardService {

    CardResponseDTO save(CardRequestDTO cardRequestDTO) throws ClassNotFoundException;

    CardResponseDTO update(String id, CardRequestDTO cardRequestDTO);

    CardResponseDTO getById(String id);

    List<CardResponseDTO> getAll();

}
