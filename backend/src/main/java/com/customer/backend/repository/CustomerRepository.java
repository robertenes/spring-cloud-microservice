package com.customer.backend.repository;

import com.customer.backend.model.entity.CustomerEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CassandraRepository<CustomerEntity, String> {

    @AllowFiltering
    Optional<CustomerEntity> findByCustomerNumber(String customerNumber);

    boolean existsByCustomerNumber(String customerNumber);
}
