package com.customer.backend.model.converter;

import com.customer.backend.model.dto.CustomerRequestDTO;
import com.customer.backend.model.dto.CustomerResponseDTO;
import com.customer.backend.model.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {

    private ModelMapper mapper;

    public CustomerConverter(final ModelMapper modelMapper) {
        this.mapper = modelMapper;
    }

    public CustomerResponseDTO convertToResponseDTO(CustomerEntity customerEntity) {

        return mapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public CustomerEntity convertToEntity(CustomerRequestDTO customerRequestDTO) {

        return mapper.map(customerRequestDTO, CustomerEntity.class);
    }

    public List<CustomerResponseDTO> convertToResponseDTOList(List<CustomerEntity> customerEntityList) {

        return customerEntityList.stream()
                .map(customerEntity -> mapper.map(customerEntity,CustomerResponseDTO.class))
                .collect(Collectors.toList());
    }
}
