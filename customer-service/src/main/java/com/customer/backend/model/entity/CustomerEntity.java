package com.customer.backend.model.entity;

import lombok.*;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table("customers")
public class CustomerEntity  implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "first_name")
    private String firstName;

    @Column(value = "last_name")
    private String lastName;

    @Column(value = "customer_number")
    private String customerNumber;

    @Column(value = "phone_number")
    private String phoneNumber;

    @Column(value = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @Column(value = "is_active")
    private Boolean active = true;

}
