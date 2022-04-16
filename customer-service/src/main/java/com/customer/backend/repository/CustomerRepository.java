package com.customer.backend.repository;

import com.customer.backend.model.entity.CustomerEntity;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

    @AllowFiltering
    Optional<CustomerEntity> findByCustomerNumberAndActiveTrue(String customerNumber);

    @AllowFiltering
    List<CustomerEntity> findAllByActiveTrue();


    @AllowFiltering
    boolean existsByCustomerNumberAndActive(String customerNumber);
}
