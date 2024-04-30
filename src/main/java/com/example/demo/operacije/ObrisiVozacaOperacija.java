package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Vozac;
import com.example.demo.exceptions.VozacNijePronadjenException;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObrisiVozacaOperacija implements GenerickaOperacija<Integer, ResponseEntity> {
    @Autowired
    private VozacRepository vozacRepository;
    @Override
    public ResponseEntity izvrsi(Integer id) {
        Optional<Vozac>optionalVozac=vozacRepository.findById(id);
        if(optionalVozac.isEmpty()){
            throw new VozacNijePronadjenException();
        }
        Vozac vozac= vozacRepository.findById(id).get();
        vozacRepository.delete(vozac);
        return ResponseEntity.ok().build();
    }
}
