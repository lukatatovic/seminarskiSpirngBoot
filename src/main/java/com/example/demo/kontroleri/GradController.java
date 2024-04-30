package com.example.demo.kontroleri;

import com.example.demo.domen.Grad;
import com.example.demo.operacije.KreirajGradOperacija;
import com.example.demo.operacije.VratiGradoveOperacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grad")
public class GradController {
    @Autowired
    private VratiGradoveOperacija vratiGradoveOperacija;
    @Autowired
    private KreirajGradOperacija kreirajGradOperacija;
    @GetMapping
    private ResponseEntity<List<Grad>> vratiGradove(){
        return vratiGradoveOperacija.izvrsi(null);
    }
    @PostMapping
    private ResponseEntity kreirajGrad(@RequestBody Grad grad){
        return kreirajGradOperacija.izvrsi(grad);
    }

}
