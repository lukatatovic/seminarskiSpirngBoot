package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class NijeValidnoException extends GenerickiException{
    public NijeValidnoException(String poruka) {
        super(HttpStatus.BAD_REQUEST, new Odgovor(poruka));
    }
}
