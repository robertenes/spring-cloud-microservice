package com.customer.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class CustomerSaveException extends RuntimeException{
    public CustomerSaveException(String message) {
        super(message);
    }
}
