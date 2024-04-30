package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Trka;
import com.example.demo.repozitorijumi.TrkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VratiSveTrkeNazivGrada implements GenerickaOperacija<String, List<Trka>> {
    @Autowired
    private TrkaRepository trkaRepository;

    @Override
    public ResponseEntity<List<Trka>> izvrsi(String naziv) {
        List<Trka> sve= trkaRepository.findAll();
        List<Trka> lista=new ArrayList<>();
        for(Trka t:sve){
            if(t.getGrad().getNaziv().toLowerCase().equals(naziv.toLowerCase())||t.getGrad().getNaziv().toLowerCase().contains(naziv.toLowerCase())){
                lista.add(t);
            }
        }
        return ResponseEntity.ok(lista);
    }
}
