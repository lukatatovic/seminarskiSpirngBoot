package com.example.demo.repozitorijumi;

import com.example.demo.domen.Vozac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VozacRepository extends JpaRepository<Vozac,Integer> {

    List<Vozac> findByImeContaining(String ime);
}
