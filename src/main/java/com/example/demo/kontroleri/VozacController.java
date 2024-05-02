package com.example.demo.kontroleri;

import com.example.demo.domen.Vozac;
import com.example.demo.domen.VozacDTO;
import com.example.demo.exceptions.VozacNijePronadjenException;
import com.example.demo.operacije.*;
import com.example.demo.repozitorijumi.VozacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vozac")
public class VozacController {
    @Autowired
    private VozacRepository vozacRepository;
    @Autowired
    private VratiSveVozaceOperacija vratiSveVozaceOperacija;
    @Autowired
    private VratiVozacaOperacija vratiVozacaOperacija;
    @Autowired
    private KreirajVozacaOperacija kreirajVozacaOperacija;
    @Autowired
    private IzmeniVozacaOperacija izmeniVozacaOperacija;
    @Autowired
    private ObrisiVozacaOperacija obrisiVozacaOperacija;
    @Autowired
    private VratiVozaceImeOperacija vratiVozaceImeOperacija;
    @GetMapping
    public ResponseEntity<List<VozacDTO>> vratiSveVozace(){
        //return ResponseEntity.ok(Collections.emptyList());
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        return vratiSveVozaceOperacija.izvrsi(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VozacDTO> vratiVozaca(@PathVariable Integer id){
        return vratiVozacaOperacija.izvrsi(id);
    }

    @GetMapping("/ime")
    public ResponseEntity<List<Vozac>> vratiVozaceIme(@RequestParam(value = "ime") String ime){
        return vratiVozaceImeOperacija.izvrsi(ime);
    }

    @PostMapping
    public ResponseEntity kreirajVozaca(@RequestBody Vozac vozac){
        return kreirajVozacaOperacija.izvrsi(vozac);
    }


    @PutMapping("/{id}")
    public ResponseEntity izmeniVozaca(@RequestBody Vozac vozac,@PathVariable Integer id){
        vozac.setId(id);
        return izmeniVozacaOperacija.izvrsi(vozac);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity obrisiVozaca(@PathVariable Integer id){
        return obrisiVozacaOperacija.izvrsi(id);
    }


}
