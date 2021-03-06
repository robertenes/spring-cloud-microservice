package com.card.backend.api;


import com.card.backend.Deneme;
import com.card.backend.model.dto.CardRequestDTO;
import com.card.backend.model.dto.CardResponseDTO;
import com.card.backend.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardApi {

    private final CardService cardService;


    Logger logger = LoggerFactory.getLogger(CardApi.class);


    public CardApi(final CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<CardResponseDTO> getCardById(@RequestHeader("id") String id) {
        return new ResponseEntity<>(cardService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CardResponseDTO>> getAll() {
        logger.info("Elmaaa");
        return new ResponseEntity<>(cardService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardResponseDTO> saveCard(@RequestBody CardRequestDTO cardRequestDTO) throws ClassNotFoundException {
        return new ResponseEntity<>(cardService.save(cardRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDTO> updateCard(@PathVariable("id") String id,
                                                    @RequestBody CardRequestDTO cardRequestDTO) {
        return new ResponseEntity<>(cardService.update(id, cardRequestDTO), HttpStatus.ACCEPTED);
    }


}
