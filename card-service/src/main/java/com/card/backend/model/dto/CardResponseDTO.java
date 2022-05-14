package com.card.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDTO {

        private String cardNumber;

        private LocalDate expirationDate;

        private String securityCode;

        private String cardType;

        private String customerNumber;
}
