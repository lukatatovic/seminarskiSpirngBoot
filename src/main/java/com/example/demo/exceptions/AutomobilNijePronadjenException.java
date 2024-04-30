package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class AutomobilNijePronadjenException extends GenerickiException{
    public AutomobilNijePronadjenException() {
        super(HttpStatus.BAD_REQUEST, new Odgovor("Automobil nije pronadjen"));
    }
}
