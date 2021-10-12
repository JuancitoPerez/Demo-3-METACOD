package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class AsdasdDontFoundException extends ResponseException{
    public AsdasdDontFoundException(long id) {
        super("El/La Asdasd con id "+ id +" no existe", HttpStatus.NOT_FOUND);
    }
}
