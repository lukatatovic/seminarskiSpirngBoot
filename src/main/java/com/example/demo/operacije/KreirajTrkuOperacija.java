package com.example.demo.operacije;

import com.example.demo.GenerickaOperacija;
import com.example.demo.domen.*;
import com.example.demo.exceptions.NijeValidnoException;
import com.example.demo.repozitorijumi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KreirajTrkuOperacija implements GenerickaOperacija<Trka, ResponseEntity> {

    @Autowired
    private TrkaRepository trkaRepository;
    @Autowired
    private GradRepository gradRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private VozacRepository vozacRepository;
    @Autowired
    private AutomobilRepository automobilRepository;
    @Autowired
    private TakmicarRepository takmicarRepository;

    @Override
    public ResponseEntity<ResponseEntity> izvrsi(Trka trka) {
        validacija(trka);
        srediPodatke(trka);
        srediListu(trka.getTakmicari());
        trkaRepository.save(trka);
        for(Takmicar takmicar:trka.getTakmicari()){
            List<Trka> trke= trkaRepository.findAll();
            int velicina= trke.size();
            takmicar.setTrka(trke.get(velicina-1).getId());
            takmicarRepository.save(takmicar);
        }
        return ResponseEntity.ok().build();
    }

    private void srediPodatke(Trka trka) {
        trka.setBrojTakmicara(trka.getTakmicari().size());
        trka.setVreme(trka.getTakmicari().get(0).getVreme());
        trka.setDuzina(trka.getGrad().getDuzinaKruga()*trka.getBrojKrugova());
    }

    private void srediListu(List<Takmicar> takmicari) {
        if(takmicari.size()<2){
            throw new NijeValidnoException("Trka mora imati bar 2 takmicara");
        }
        for(Takmicar takmicar:takmicari){
            if(takmicar.getStartnaPozicija()>takmicari.size()){
                throw new NijeValidnoException("Startna pozicija ne moze biti veca od broja takmicara");
            }
        }
        for(int i=0;i<takmicari.size()-1;i++){
            for (int j=i+1;j<takmicari.size();j++){
                Takmicar t1= takmicari.get(i);
                Takmicar t2= takmicari.get(j);
                if(t2.getVreme().before(t1.getVreme())){
                    takmicari.set(i,t2);
                    takmicari.set(j,t1);
                }
            }
        }
        for(int k=0;k<takmicari.size();k++){
            takmicari.get(k).setZavrsnaPozicija(k+1);
        }
        for(int m=0;m<takmicari.size()-1;m++){
            for (int n=m+1;n<takmicari.size();n++){
                if(takmicari.get(m).getVozac().equals(takmicari.get(n).getVozac())){
                    throw new NijeValidnoException("Isti takmicar ne moze 2 puta da ucestvuje u istoj trci");
                }
            }
        }
    }

    private void validacija(Trka trka) {
        if(trka.getBrojKrugova()<1){
            throw new NijeValidnoException("Broj krugova mora biti veci od 0");
        }

        if(trka.getGrad()==null){
            throw new NijeValidnoException("Trka se mora odrzati u nekom gradu");
        }

        List<Grad> gradovi= gradRepository.findAll();
        if(!gradovi.contains(trka.getGrad())){
            throw new NijeValidnoException("Grad ne postoji u bazi podataka");
        }
        if(trka.getKorisnik()==null){
            throw new NijeValidnoException("Trku mora uneti neki korisnik");
        }
        List<Korisnik> korisnici= korisnikRepository.findAll();
        if(!korisnici.contains(trka.getKorisnik())){
            throw new NijeValidnoException("Korisnik ne postoji u bazi podataka");
        }
        List<Vozac> vozaci= vozacRepository.findAll();
        List<Automobil> automobili=automobilRepository.findAll();
        for(Takmicar tak:trka.getTakmicari()){
            if(!automobili.contains(tak.getAutomobil())||!vozaci.contains(tak.getVozac())){
                throw new NijeValidnoException("Automobil ili vozac ne postoji u bazi podataka");
            }
        }
    }
}
