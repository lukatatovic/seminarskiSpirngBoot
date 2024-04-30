package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalniExceptionHandler {
    @ExceptionHandler(VozacNijePronadjenException.class)
    public ResponseEntity<Odgovor> handleVozacNijePronadjenException(GenerickiException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getOdgovor());
    }
    @ExceptionHandler(AutomobilNijePronadjenException.class)
    public ResponseEntity<Odgovor> handleAutomobilNijePronadjenException(GenerickiException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getOdgovor());
    }
    @ExceptionHandler(TrkaNijePronadjenaException.class)
    public ResponseEntity<Odgovor> handleTrkaNijeProndajenaException(GenerickiException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getOdgovor());
    }
    @ExceptionHandler(NijeValidnoException.class)
    public ResponseEntity<Odgovor> handleNijeValidno(GenerickiException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getOdgovor());
    }

}
