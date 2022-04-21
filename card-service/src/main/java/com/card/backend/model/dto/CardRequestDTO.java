package com.card.backend.model.dto;

import com.card.backend.model.entity.CardType;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class CardRequestDTO {

    private String cardNumber;

    private LocalDate expirationDate;

    private String securityCode;

    private String cardType;

    private String customerNumber;
}
