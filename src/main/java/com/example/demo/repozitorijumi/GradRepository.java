package com.example.demo.repozitorijumi;

import com.example.demo.domen.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradRepository extends JpaRepository<Grad,Integer> {
}
