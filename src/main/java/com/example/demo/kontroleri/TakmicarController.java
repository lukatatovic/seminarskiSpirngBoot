package com.example.demo.kontroleri;

import com.example.demo.domen.Takmicar;
import com.example.demo.domen.Trka;
import com.example.demo.repozitorijumi.TakmicarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/takmicar")
public class TakmicarController {
    @Autowired
    private TakmicarRepository takmicarRepository;

    @GetMapping
    private ResponseEntity<List<Takmicar>> vratiSveTrke(){
        return ResponseEntity.ok(takmicarRepository.findAll());
    }
}
