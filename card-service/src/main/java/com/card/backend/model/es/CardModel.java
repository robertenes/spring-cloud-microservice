package com.card.backend.model.es;

import com.card.backend.model.entity.CardType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Document(indexName = "card")
@AllArgsConstructor
@NoArgsConstructor
public class CardModel implements Serializable {

    @Id
    private String id;

    private String cardNumber;

    private LocalDate expirationDate;

    private String securityCode;

    private String customerNumber;

    private String cardType;

    private String active;

    private String customerNameSurname;

}
