package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class TrkaNijePronadjenaException extends GenerickiException{
    public TrkaNijePronadjenaException() {
        super(HttpStatus.BAD_REQUEST, new Odgovor("Trka nije pronadjena"));
    }
}
