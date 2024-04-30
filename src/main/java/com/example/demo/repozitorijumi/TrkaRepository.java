package com.example.demo.repozitorijumi;

import com.example.demo.domen.Trka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrkaRepository extends JpaRepository<Trka,Integer> {



}
