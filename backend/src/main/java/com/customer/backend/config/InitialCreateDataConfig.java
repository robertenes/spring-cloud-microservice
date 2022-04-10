package com.customer.backend.config;

import com.customer.backend.model.dto.CustomerRequestDTO;
import com.customer.backend.service.abstracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Configuration
public class InitialCreateDataConfig {

    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void init() {
        CustomerRequestDTO customerRequestDTO = CustomerRequestDTO.builder()
                .customerNumber("1234")
                .firstName("Zoey")
                .lastName("Cyrus")
                .phoneNumber("05074332011")
                .createdAt(LocalDate.now())
                .build();
        customerService.saveCustomer(customerRequestDTO);
    }

    @Bean
    CommandLineRunner createInitialCustomer() {
        return args -> {
            CustomerRequestDTO customerRequestDTO = CustomerRequestDTO.builder()
                    .customerNumber("5678")
                    .firstName("Jack")
                    .lastName("Lavigne")
                    .phoneNumber("05388974563")
                    .createdAt(LocalDate.now())
                    .build();
            customerService.saveCustomer(customerRequestDTO);
        };
    }

}
