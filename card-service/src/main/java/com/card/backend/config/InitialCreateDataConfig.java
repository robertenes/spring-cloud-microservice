package com.card.backend.config;

import com.card.backend.model.dto.CardRequestDTO;
import com.card.backend.model.entity.CardType;
import com.card.backend.service.CardService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class InitialCreateDataConfig {

    private final CardService cardService;

    public InitialCreateDataConfig (final CardService cardService) {
        this.cardService = cardService;
    }

/*    @PostConstruct
    public void init() throws ClassNotFoundException {
        CardRequestDTO cardRequestDTO = CardRequestDTO.builder()
                .cardNumber("1234566")
                .cardType("Bank Card")
                .expirationDate(LocalDate.now())
                .securityCode("1234")
                .build();
        cardService.save(cardRequestDTO);
    }*/

//    @Bean
//    CommandLineRunner createInitialCustomer() {
//        return args -> {
//            CardRequestDTO cardRequestDTO = CardRequestDTO.builder()
//                    .cardNumber("987654")
//                    .cardType("Credit Card")
//                    .expirationDate(LocalDate.now())
//                    .securityCode("987654")
//                    .build();
//            cardService.save(cardRequestDTO);
//        };
//    }



}
