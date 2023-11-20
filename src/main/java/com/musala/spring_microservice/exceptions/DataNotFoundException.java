package com.musala.spring_microservice.exceptions;

import lombok.Getter;

@Getter
public class DataNotFoundException extends Exception{

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
