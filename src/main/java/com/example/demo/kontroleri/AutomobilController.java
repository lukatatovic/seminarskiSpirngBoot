package com.example.demo.kontroleri;

import com.example.demo.domen.Automobil;
import com.example.demo.operacije.IzmeniAutomobilOperacija;
import com.example.demo.operacije.KreirajAutomobilOperacija;
import com.example.demo.operacije.VratiAutomobileMarkaOperacija;
import com.example.demo.operacije.VratiSveAutomobileOperacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automobil")
public class AutomobilController {
    @Autowired
    private VratiSveAutomobileOperacija vratiSveAutomobileOperacija;
    @Autowired
    private VratiAutomobileMarkaOperacija vratiAutomobileMarkaOperacija;
    @Autowired
    private KreirajAutomobilOperacija kreirajAutomobilOperacija;
    @Autowired
    private IzmeniAutomobilOperacija izmeniAutomobilOperacija;
    @GetMapping
    private ResponseEntity<List<Automobil>> vratiSveAutomobile(){
        return vratiSveAutomobileOperacija.izvrsi(null);
    }

    @GetMapping("/marka")
    private ResponseEntity<List<Automobil>> vratiAutomobileMarka(@RequestParam(value = "marka")String marka){
        return vratiAutomobileMarkaOperacija.izvrsi(marka);
    }
    @PostMapping
    private ResponseEntity kreirajAutomobil (@RequestBody Automobil automobil){
        return kreirajAutomobilOperacija.izvrsi(automobil);
    }
    @PutMapping("/{id}")
    private ResponseEntity izmeniAutomobil(@RequestBody Automobil automobil,@PathVariable Integer id){
        automobil.setId(id);
        return izmeniAutomobilOperacija.izvrsi(automobil);
    }
}
