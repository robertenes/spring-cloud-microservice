package com.customer.backend.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private long id;
    private String customerNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
