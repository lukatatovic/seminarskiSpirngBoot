package com.example.demo.domen;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "korisnik")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
