package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Grad;
import com.example.demo.exceptions.NijeValidnoException;
import com.example.demo.repozitorijumi.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KreirajGradOperacija implements GenerickaOperacija<Grad, ResponseEntity> {
    @Autowired
    private GradRepository gradRepository;

    @Override
    public ResponseEntity<ResponseEntity> izvrsi(Grad grad) {
        validacija(grad);

        gradRepository.save(grad);
        return ResponseEntity.ok().build();
    }

    private void validacija(Grad grad) {
        if(grad.getNaziv().isBlank()){
            throw new NijeValidnoException("Naziv ne moze biti prazan");
        }
        if(grad.getDuzinaKruga()<=0.0){
            throw new NijeValidnoException("Duzina kruga ne moze biti manja ili jednaka 0.0");
        }

    }
}
