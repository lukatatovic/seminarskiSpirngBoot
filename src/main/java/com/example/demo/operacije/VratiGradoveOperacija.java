package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Grad;
import com.example.demo.repozitorijumi.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VratiGradoveOperacija implements GenerickaOperacija<Void, List<Grad>> {
    @Autowired
    private GradRepository gradRepository;

    @Override
    public ResponseEntity<List<Grad>> izvrsi(Void input) {
        return ResponseEntity.ok(gradRepository.findAll());
    }
}
