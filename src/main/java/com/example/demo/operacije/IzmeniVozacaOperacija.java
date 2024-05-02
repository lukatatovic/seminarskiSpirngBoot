package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Vozac;
import com.example.demo.exceptions.NijeValidnoException;
import com.example.demo.exceptions.VozacNijePronadjenException;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IzmeniVozacaOperacija implements GenerickaOperacija<Vozac, ResponseEntity> {
    @Autowired
    private VozacRepository vozacRepository;
    @Override
    @CachePut(value = "vozacCache",key = "#vozac.getId()")
    public ResponseEntity izvrsi(Vozac vozac) {
        Optional<Vozac>optionalVozac=vozacRepository.findById(vozac.getId());
        if(optionalVozac.isEmpty()){
            throw new VozacNijePronadjenException();
        }
        validacija(vozac);
        vozacRepository.save(vozac);
        return ResponseEntity.ok(vozac);
    }

    private void validacija(Vozac vozac) {
        if(vozac.getIme().isBlank()){
            throw new NijeValidnoException("Greska");
        }
        if(vozac.getPrezime().isBlank()){
            throw new NijeValidnoException("Greska");
        }
        if(vozac.getDrzava().isBlank()){
            throw new NijeValidnoException("Greska");
        }
        if(vozac.getDatum_rodjenja()==null){
            throw new NijeValidnoException("Greska");
        }
    }

}
