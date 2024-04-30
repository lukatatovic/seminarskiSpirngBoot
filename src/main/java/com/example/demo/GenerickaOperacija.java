package com.example.demo;

import org.springframework.http.ResponseEntity;

public interface GenerickaOperacija<I,O> {
    ResponseEntity<O> izvrsi(I input);
}
