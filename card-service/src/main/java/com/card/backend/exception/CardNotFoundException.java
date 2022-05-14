package com.card.backend.exception;

import javax.ws.rs.HttpMethod;


public class CardNotFoundException extends RuntimeException{

    public CardNotFoundException(String message) {
        super(message);
    }

}
