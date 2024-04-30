package com.example.demo.domen;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Entity
@Data
@Table(name = "trka")
public class Trka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "duzina")
    private Double duzina;
    @Column(name = "broj_krugova")
    private Integer brojKrugova;
    @Column(name = "broj_takmicara")
    private Integer brojTakmicara;
    @Column(name = "vreme")
    private Time vreme;
    @Column(name = "trka_suvo")
    private Boolean trkaPoSuvom;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "grad_id")
    private Grad grad;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @OneToMany
    @JoinColumn(name = "trka_id")
    private List<Takmicar> takmicari;
}
