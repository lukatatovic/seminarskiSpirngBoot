package com.example.demo.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class GenerickiException extends RuntimeException{
    private HttpStatus status;
    private Odgovor odgovor;

    public GenerickiException(HttpStatus status, Odgovor odgovor) {
        this.status = status;
        this.odgovor = odgovor;
    }
}
