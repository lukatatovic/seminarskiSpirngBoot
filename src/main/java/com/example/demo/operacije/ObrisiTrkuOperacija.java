package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.Takmicar;
import com.example.demo.domen.Trka;
import com.example.demo.exceptions.TrkaNijePronadjenaException;
import com.example.demo.repozitorijumi.TakmicarRepository;
import com.example.demo.repozitorijumi.TrkaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObrisiTrkuOperacija implements GenerickaOperacija<Integer, ResponseEntity> {
    @Autowired
    private TrkaRepository trkaRepository;
    @Autowired
    private TakmicarRepository takmicarRepository;

    @Override
    public ResponseEntity<ResponseEntity> izvrsi(Integer id) {
        Optional<Trka> optionalTrka=trkaRepository.findById(id);
        if(optionalTrka.isEmpty()){
            throw new TrkaNijePronadjenaException();
        }
        Trka brisanje= optionalTrka.get();
        for(Takmicar takmicar:brisanje.getTakmicari()){
            takmicarRepository.delete(takmicar);
        }
        trkaRepository.delete(brisanje);
        return ResponseEntity.ok().build();
    }
}
