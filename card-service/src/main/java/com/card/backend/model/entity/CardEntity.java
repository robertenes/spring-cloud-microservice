package com.card.backend.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
@Entity
@Table(name = "cards")
public class CardEntity extends BaseEntityModel {

    @Id
    @Getter
    private String id = UUID.randomUUID().toString();

    @Getter
    @Setter
    @Column(name = "card_number")
    private String cardNumber;

    @Getter
    @Setter
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Getter
    @Setter
    @Column(name = "security_code")
    private String securityCode;

    @Getter
    @Setter
    @Column(name = "customer_number")
    private String customerNumber;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Getter
    @Setter
    @Column(name ="is_active")
    private boolean active;
}
