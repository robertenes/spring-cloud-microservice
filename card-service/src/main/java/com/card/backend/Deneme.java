package com.card.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Deneme {

    private String name = "ENES";

    @Bean
    public String getName() {
        return name;
    }


}
