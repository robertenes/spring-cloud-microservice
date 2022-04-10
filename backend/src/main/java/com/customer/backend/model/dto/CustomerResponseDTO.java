package com.customer.backend.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {

    private String customerNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate createdAt;



}
