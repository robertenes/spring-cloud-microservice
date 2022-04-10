package com.customer.backend.model.dto;

import com.customer.backend.validation.UniqueCustomerName;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class CustomerRequestDTO {

    @NotNull(message = "{backend.constraints.customernumber.NotNull.message}")
    @Size(min = 3, message = "{backend.constraints.customernumber.Size.message}")
    @UniqueCustomerName(message = "{backend.constraints.customernumber.Unique.message}")
    private String customerNumber;

    @NotNull(message = "{backend.firstname.NotNull.message}")
    @Size(min = 2, max = 12, message = "{backend.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastname.NotNull.message}")
    @Size(min = 2, max = 25, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

    @NotNull(message = "{backend.constraints.phonenumber.NotNull.message}")
    @Size(min = 11, max = 11, message = "{backend.constraints.phonenumber.Size.message}")
    private String phoneNumber;

    private LocalDate createdAt;

}
