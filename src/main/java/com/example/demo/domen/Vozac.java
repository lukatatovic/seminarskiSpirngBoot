package com.example.demo.domen;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="vozac")
public class Vozac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="ime")
    private String ime;

    @Column(name="prezime")
    private String prezime;

    @Column(name="datum_rodjenja")
    private Date datum_rodjenja;

    @Column(name="drzava")
    private String drzava;

}
