package com.example.demo.kontroleri;

import com.example.demo.domen.Trka;
import com.example.demo.operacije.KreirajTrkuOperacija;
import com.example.demo.operacije.ObrisiTrkuOperacija;
import com.example.demo.operacije.VratiSveTrkeNazivGrada;
import com.example.demo.operacije.VratiSveTrkeOperacija;
import com.example.demo.repozitorijumi.TrkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trka")
public class TrkaKontroler {
    @Autowired
    private VratiSveTrkeOperacija vratiSveTrkeOperacija;
    @Autowired
    private VratiSveTrkeNazivGrada vratiSveTrkeNazivGrada;
    @Autowired
    private KreirajTrkuOperacija kreirajTrkuOperacija;
    @Autowired
    private ObrisiTrkuOperacija obrisiTrkuOperacija;

    @GetMapping
    private ResponseEntity<List<Trka>> vratiSveTrke(){
        return vratiSveTrkeOperacija.izvrsi(null);
    }
    @GetMapping("/naziv")
    private ResponseEntity<List<Trka>> vratiTrkeNaziv(@RequestParam(value = "naziv")String naziv){
        return vratiSveTrkeNazivGrada.izvrsi(naziv);
    }
    @PostMapping
    private ResponseEntity kreirajTrku(@RequestBody Trka trka){
        return kreirajTrkuOperacija.izvrsi(trka);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity obrisiTrku(@PathVariable Integer id){
        return obrisiTrkuOperacija.izvrsi(id);
    }
}
