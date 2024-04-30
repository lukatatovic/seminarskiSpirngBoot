package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Automobil;
import com.example.demo.repozitorijumi.AutomobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VratiAutomobileMarkaOperacija implements GenerickaOperacija<String, List<Automobil>> {
    @Autowired
    private AutomobilRepository automobilRepository;
    @Override
    public ResponseEntity<List<Automobil>> izvrsi(String marka) {
        return ResponseEntity.ok(automobilRepository.findByMarkaContaining(marka));
    }
}
