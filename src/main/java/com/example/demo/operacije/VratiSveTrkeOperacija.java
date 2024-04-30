package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Trka;
import com.example.demo.repozitorijumi.TrkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VratiSveTrkeOperacija implements GenerickaOperacija<Void, List<Trka>> {
    @Autowired
    private TrkaRepository trkaRepository;

    @Override
    public ResponseEntity<List<Trka>> izvrsi(Void input) {
        return ResponseEntity.ok(trkaRepository.findAll());
    }
}
