package com.example.demo.domen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.sql.Time;

@Entity
@Data
@Table(name = "takmicar")
public class Takmicar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //@ManyToOne
    //@JoinColumn(name = "trka_id")
    //@JsonIgnore
    //private Trka trka;
    @Column(name = "trka_id")
    private Integer trka;

    @Column(name = "start")
    private Integer startnaPozicija;
    @Column(name = "kraj")
    private Integer zavrsnaPozicija;
    @Column(name = "broj_automobila")
    private Integer brojNaAutomobilu;
    @Column(name = "vreme")
    private Time vreme;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "vozac_id")
    private Vozac vozac;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "automobil_id")
    private Automobil automobil;

}
