package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Vozac;
import com.example.demo.domen.VozacDTO;
import com.example.demo.exceptions.VozacNijePronadjenException;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VratiVozacaOperacija implements GenerickaOperacija<Integer, VozacDTO> {
    @Autowired
    private VozacRepository vozacRepository;
    @Override
    public ResponseEntity<VozacDTO> izvrsi(Integer id) {
        Optional<Vozac> vozac=vozacRepository.findById(id);
        if(vozac.isEmpty()){
            throw new VozacNijePronadjenException();
        }
        return ResponseEntity.ok(new VozacDTO(vozac.get()));
    }
}
