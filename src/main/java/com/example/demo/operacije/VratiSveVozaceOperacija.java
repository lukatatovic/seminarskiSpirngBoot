package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Vozac;
import com.example.demo.domen.VozacDTO;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VratiSveVozaceOperacija implements GenerickaOperacija<Void, List<VozacDTO>> {
    @Autowired
    private VozacRepository vozacRepository;
    @Override
    public ResponseEntity<List<VozacDTO>> izvrsi(Void input) {
        List<VozacDTO> vozacDTOS= vozacRepository.findAll()
                .stream().
                map(VozacDTO::new).
                toList();
        return ResponseEntity.ok(vozacDTOS);
    }
}
