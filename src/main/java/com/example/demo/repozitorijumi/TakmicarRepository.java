package com.example.demo.repozitorijumi;

import com.example.demo.domen.Takmicar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakmicarRepository extends JpaRepository<Takmicar,Integer> {
}
