package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class AsdasdAlreadyExistException extends ResponseException{
    public AsdasdAlreadyExistException() {
        super("El/La Asdasd ya existe ", HttpStatus.BAD_REQUEST);
    }
}
