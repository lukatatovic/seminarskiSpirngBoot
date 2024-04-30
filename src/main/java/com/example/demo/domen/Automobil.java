package com.example.demo.domen;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "automobil")
public class Automobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marka")
    private String marka;
    @Column(name = "model")
    private String model;
    @Column(name = "broj_ks")
    private Integer brojKS;
    @Column(name = "zapremina_motora")
    private Double zapreminaMotora;

}
