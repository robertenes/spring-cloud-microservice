package com.common.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public String getFirstNameLastName() {
        StringBuilder builder = new StringBuilder();
        return builder.append(firstName).append(" ").append(lastName).toString();
    }

}
