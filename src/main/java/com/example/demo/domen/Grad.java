package com.example.demo.domen;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "grad")
public class Grad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "duzina_kruga")
    private Double duzinaKruga;

}
