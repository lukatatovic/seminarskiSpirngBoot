package com.example.demo.repozitorijumi;

import com.example.demo.domen.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Integer> {
}
