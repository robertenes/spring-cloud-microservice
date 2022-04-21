package com.customer.backend.service.concretes;

import com.common.backend.dto.CustomerResponseDTO;
import com.customer.backend.exception.CustomerNotFoundException;
import com.customer.backend.model.converter.CustomerConverter;
import com.customer.backend.exception.CustomerSaveException;
import com.customer.backend.model.dto.CustomerRequestDTO;
import com.customer.backend.model.entity.CustomerEntity;
import com.customer.backend.repository.CustomerRepository;
import com.customer.backend.service.abstracts.CustomerService;
import com.customer.backend.shared.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.customer.backend.util.constant.CustomerConstant.*;


@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerServiceImp(final CustomerRepository customerRepository,
                              final CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    @Override
    public CustomerResponseDTO getCustomerByCustomerNumber(String customerNumber) {

        final CustomerEntity entity = customerRepository.findByCustomerNumberAndActiveTrue(customerNumber).orElseThrow(() -> new CustomerNotFoundException(CUSTOMER_NOT_FOUND));
        return customerConverter.convertToResponseDTO(entity);
    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {

        List<CustomerEntity> customerEntityList = customerRepository.findAllByActiveTrue();
        return customerConverter.convertToResponseDTOList(customerEntityList);
    }

    @Override
    public Result saveCustomer(final CustomerRequestDTO customerRequestDTO) {

        final CustomerEntity customer = customerRepository.save(customerConverter.convertToEntity(customerRequestDTO));

        if (customer != null) {
            return new Result(CUSTOMER_SAVE_SUCCESS);
        }
        throw new CustomerSaveException(CUSTOMER_SAVE_FAILED);
    }

    @Override
    @Transactional
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO, String customerNumber) {

        final CustomerEntity customerEntity = customerRepository.findByCustomerNumberAndActiveTrue(customerNumber).orElseThrow(() -> new CustomerNotFoundException(CUSTOMER_NOT_FOUND));
        final CustomerEntity customerEntityUpdated = customerConverter.convertToEntity(customerRequestDTO);
        customerEntityUpdated.setId(customerEntity.getId());
        customerEntityUpdated.setCreatedAt(customerEntity.getCreatedAt());
        customerEntityUpdated.setActive(customerEntity.getActive());
        customerRepository.save(customerEntityUpdated);

        return customerConverter.convertToResponseDTO(customerEntityUpdated);
    }

    @Override
    @Transactional
    public Result deleteCustomer(String customerNumber) {
        CustomerEntity customerEntity = customerRepository.findByCustomerNumberAndActiveTrue(customerNumber).orElseThrow(() -> new CustomerNotFoundException(CUSTOMER_NOT_FOUND));
        customerEntity.setActive(false);
        customerRepository.save(customerEntity);
        return new Result(CUSTOMER_DELETE_SUCCESS);
    }

    @Override
    public boolean existCustomerNameControl(String value) {

        return customerRepository.existsByCustomerNumberAndActive(value);
    }

}
