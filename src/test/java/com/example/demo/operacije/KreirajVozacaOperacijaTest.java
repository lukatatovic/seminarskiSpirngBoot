package com.example.demo.operacije;

import com.example.demo.domen.Vozac;
import com.example.demo.exceptions.NijeValidnoException;
import com.example.demo.repozitorijumi.VozacRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class KreirajVozacaOperacijaTest {
    @InjectMocks
    private KreirajVozacaOperacija kreirajVozacaOperacija;
    @Mock
    private VozacRepository vozacRepository;

    @Test
    public void izvrsi(){
        Vozac vozac= new Vozac();
        vozac.setId(1);
        vozac.setIme("Test ime");
        vozac.setPrezime(("Test prezime"));
        vozac.setDrzava("Test drzava");
        vozac.setDatum_rodjenja(new Date());

        ResponseEntity responseEntity= kreirajVozacaOperacija.izvrsi(vozac);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
    @Test
    public void izvrsiLoseIme(){
        Vozac vozac= new Vozac();
        vozac.setId(1);
        vozac.setIme("");
        vozac.setPrezime(("Test prezime"));
        vozac.setDrzava("Test drzava");
        vozac.setDatum_rodjenja(new Date());

        NijeValidnoException exception= assertThrows(NijeValidnoException.class,()->kreirajVozacaOperacija.izvrsi(vozac));
        assertEquals("Ime ne moze biti prazno",exception.getOdgovor().getPoruka());

    }
    @Test
    public void izvrsiLosDatum(){
        Vozac vozac= new Vozac();
        vozac.setId(1);
        vozac.setIme("Test ime");
        vozac.setPrezime(("Test prezime"));
        vozac.setDrzava("Test drzava");

        NijeValidnoException exception= assertThrows(NijeValidnoException.class,()->kreirajVozacaOperacija.izvrsi(vozac));
        assertEquals("Datum ne moze biti prazan",exception.getOdgovor().getPoruka());

    }
}