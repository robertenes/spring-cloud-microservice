package com.customer.backend.validation;

import com.customer.backend.service.abstracts.CustomerService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerNumberValidator implements ConstraintValidator<UniqueCustomerName, String> {

    private final CustomerService customerService;

    public CustomerNumberValidator(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return !customerService.existCustomerNameControl(value);
    }
}
