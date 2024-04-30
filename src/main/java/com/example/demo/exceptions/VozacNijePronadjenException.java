package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class VozacNijePronadjenException extends GenerickiException{


    public VozacNijePronadjenException() {
        super(HttpStatus.BAD_REQUEST,new Odgovor("Vozac nije pronadjen"));
    }
}
