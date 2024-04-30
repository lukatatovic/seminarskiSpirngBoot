package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Automobil;
import com.example.demo.exceptions.NijeValidnoException;
import com.example.demo.repozitorijumi.AutomobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KreirajAutomobilOperacija implements GenerickaOperacija<Automobil, ResponseEntity> {
    @Autowired
    private AutomobilRepository automobilRepository;

    @Override
    public ResponseEntity<ResponseEntity> izvrsi(Automobil automobil) {
        validacija(automobil);
        automobilRepository.save(automobil);
        return ResponseEntity.ok().build();
    }

    private void validacija(Automobil automobil) {
        if(automobil.getMarka().isBlank()){
            throw new NijeValidnoException("Marka ne moze biti prazna");
        }
        if(automobil.getModel().isBlank()){
            throw new NijeValidnoException("Model ne moze biti prazan");
        }
        if(automobil.getBrojKS()<=0){
            throw new NijeValidnoException("Broj KS ne moze biti manji ili jednak 0");
        }
        if(automobil.getZapreminaMotora()<=0.0){
            throw new NijeValidnoException("Zapremina ne moze biti manja ili jednaka 0.0");
        }

    }
}
