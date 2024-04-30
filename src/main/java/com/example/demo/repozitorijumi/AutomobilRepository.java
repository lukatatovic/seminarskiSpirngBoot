package com.example.demo.repozitorijumi;

import com.example.demo.domen.Automobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil,Integer> {
    List<Automobil> findByMarkaContaining(String marka);
}
