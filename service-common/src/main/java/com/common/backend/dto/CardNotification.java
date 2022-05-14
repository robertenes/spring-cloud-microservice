package com.common.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CardNotification{

    private String cardId;
    private String customerNumber;
    private String customerMail;

}
