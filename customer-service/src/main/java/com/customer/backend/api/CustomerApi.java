package com.customer.backend.api;

import com.common.backend.dto.CustomerResponseDTO;
import com.customer.backend.model.dto.CustomerRequestDTO;
import com.customer.backend.service.abstracts.CustomerService;
import com.customer.backend.shared.result.Result;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    private final CustomerService customerService;

    public CustomerApi(final CustomerService customerService) {

        this.customerService = customerService;
    }

    @GetMapping("/getCustomerByCustomerNumber/{customerNumber}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByCustomerNumber(@PathVariable String customerNumber) {

        return new ResponseEntity<>(customerService.getCustomerByCustomerNumber(customerNumber), HttpStatus.OK);
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Result> saveCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {

        final Result result = customerService.saveCustomer(customerRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PutMapping("/updateCustomer/{customerNumber}")
    public ResponseEntity<CustomerResponseDTO> updateCuswtomer(@PathVariable("customerNumber") String customerNumber,
                                                               @RequestBody CustomerRequestDTO customerRequestDTO) {

        return new ResponseEntity<>(customerService.updateCustomer(customerRequestDTO, customerNumber), HttpStatus.OK);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<CustomerResponseDTO>> getCustomers() {

        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{customerNumber}")
    public ResponseEntity<Result> deleteCustomer(@PathVariable("customerNumber") String customerNumber) {
        return new ResponseEntity<>(customerService.deleteCustomer(customerNumber), HttpStatus.OK);
    }

}
