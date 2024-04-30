package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Automobil;
import com.example.demo.repozitorijumi.AutomobilRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VratiSveAutomobileOperacija implements GenerickaOperacija<Void, List<Automobil>> {
    @Autowired
    private AutomobilRepository automobilRepository;
    @Override
    public ResponseEntity<List<Automobil>> izvrsi(Void input) {
        return ResponseEntity.ok(automobilRepository.findAll());
    }
}
