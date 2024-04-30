package com.example.demo.operacije;

import com.example.demo.domen.Vozac;
import com.example.demo.domen.VozacDTO;
import com.example.demo.exceptions.VozacNijePronadjenException;
import com.example.demo.repozitorijumi.VozacRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VratiVozacaOperacijaTest {
    @InjectMocks
    private VratiVozacaOperacija vratiVozacaOperacija;
    @Mock
    private VozacRepository vozacRepository;
    @Test
    public void vratiVozacaOperacija(){
        Vozac vozac= new Vozac();
        vozac.setId(1);
        vozac.setIme("Test ime");
        vozac.setPrezime(("Test prezime"));
        vozac.setDrzava("Test drzava");
        vozac.setDatum_rodjenja(new Date());

        VozacDTO ocekivani= new VozacDTO(vozac);

        when(vozacRepository.findById(vozac.getId())).thenReturn(Optional.of(vozac));

        ResponseEntity<VozacDTO> vozacDTO = vratiVozacaOperacija.izvrsi(vozac.getId());
        assertEquals(ocekivani,vozacDTO.getBody());
        assertEquals(HttpStatus.OK,vozacDTO.getStatusCode());

    }
    @Test
    public void vratiVozacaOperacijaGreska(){
        when(vozacRepository.findById(1)).thenReturn(Optional.empty());
        VozacNijePronadjenException vozacNijePronadjenException= assertThrows(VozacNijePronadjenException.class,()->vratiVozacaOperacija.izvrsi(1));
        assertEquals("Vozac nije pronadjen",vozacNijePronadjenException.getOdgovor().getPoruka());
    }
}