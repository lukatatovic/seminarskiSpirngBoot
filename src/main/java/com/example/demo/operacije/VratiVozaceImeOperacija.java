package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Vozac;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VratiVozaceImeOperacija implements GenerickaOperacija<String, List<Vozac>> {
    @Autowired
    private VozacRepository vozacRepository;

    @Override
    public ResponseEntity<List<Vozac>> izvrsi(String ime) {
        return ResponseEntity.ok(vozacRepository.findByImeContaining(ime));
    }
}
