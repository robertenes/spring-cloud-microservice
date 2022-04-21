package com.common.backend;

import com.common.backend.dto.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CUSTOMER-SERVICE", configuration = FeignClientConfig.class)
public interface CustomerServiceClient {

    @RequestMapping(value = "/api/getCustomerByCustomerNumber/{customerNumber}", method = RequestMethod.GET)
    ResponseEntity<CustomerResponseDTO> getCustomerByCustomerNumber( @PathVariable String customerNumber);

}
