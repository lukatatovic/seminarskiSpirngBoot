package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Vozac;
import com.example.demo.exceptions.NijeValidnoException;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KreirajVozacaOperacija implements GenerickaOperacija<Vozac, ResponseEntity> {
    @Autowired
    private VozacRepository vozacRepository;
    @Override
    public ResponseEntity izvrsi(Vozac vozac) {
        validacija(vozac);

        vozacRepository.save(vozac);
        return ResponseEntity.ok().build();
    }
    private void validacija(Vozac vozac){
        if(vozac.getIme().isBlank()){
            throw new NijeValidnoException("Ime ne moze biti prazno");
        }
        if(vozac.getPrezime().isBlank()){
            throw new NijeValidnoException("Prezime ne moze biti prazno");
        }
        if(vozac.getDrzava().isBlank()){
            throw new NijeValidnoException("Drzava ne moze biti prazna");
        }
        if(vozac.getDatum_rodjenja()==null){
            throw new NijeValidnoException("Datum ne moze biti prazan");
        }
    }
}
