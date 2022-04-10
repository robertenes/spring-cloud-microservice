package com.customer.backend.service.abstracts;

import com.customer.backend.model.dto.CustomerRequestDTO;
import com.customer.backend.model.dto.CustomerResponseDTO;
import com.customer.backend.shared.result.Result;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO getCustomerByCustomerNumber(String customerNumber);

    Result saveCustomer(final CustomerRequestDTO customerCreateDTO);

    CustomerResponseDTO updateCustomer(final CustomerRequestDTO customerRequestDTO, String customerNumber);

    List<CustomerResponseDTO> getCustomers();

    Result deleteCustomer(String customerNumber);

    boolean existCustomerNameControl(String value);

}
