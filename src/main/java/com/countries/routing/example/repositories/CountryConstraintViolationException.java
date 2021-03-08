package com.countries.routing.example.repositories;

public class CountryConstraintViolationException extends RuntimeException {

    public CountryConstraintViolationException(String message) {
        super(message);
    }

}
