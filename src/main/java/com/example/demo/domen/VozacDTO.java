package com.example.demo.domen;

import lombok.Data;

@Data
public class VozacDTO {
    private String ime;
    private String prezime;
    private String drzava;

    public VozacDTO(Vozac vozac) {
        this.ime=vozac.getIme();
        this.prezime=vozac.getPrezime();
        this.drzava=vozac.getDrzava();
    }
}
