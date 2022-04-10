package com.customer.backend.advice;

import com.customer.backend.exception.CustomerNotFoundException;
import com.customer.backend.exception.CustomerSaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.http.HttpHeaders;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionResponse> customerNotFound(Exception exception, WebRequest webRequest) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), exception.getMessage(), "1000");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerSaveException.class)
    public ResponseEntity<ExceptionResponse> customerSaveException(Exception exception, WebRequest webRequest) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), exception.getMessage(), "2000");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> map = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    map.put(fieldName, message);
                }
        );
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
