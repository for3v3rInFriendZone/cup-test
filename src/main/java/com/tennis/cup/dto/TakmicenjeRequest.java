package com.tennis.cup.dto;

import java.time.LocalDate;
import org.hibernate.validator.constraints.Length;

/**
 * Klasa koja definise vrednosti neophodne da bi se napravilo novo Takmicenje (ovo salju klijenti kao sto su React ili Postman)
 * Salje se JSON, koji posle Jackson biblioteka koja se nalazi u Spring-u mapira na ovaj objekat.
 */
public class TakmicenjeRequest {

    private Long id;

    private String naziv;

    // Mesto odrzavanja ne sme da bude duze od 50 karaktera
    @Length(max = 50)
    private String mestoOdrzavanja;

    private LocalDate datumPocetka;

    private LocalDate datumZavrsetka;

    // Za Takmicenje, salje se formatId, da bi se znalo kom formatu Takmicenje pripada
    private Long formatId;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMestoOdrzavanja() {
        return mestoOdrzavanja;
    }

    public void setMestoOdrzavanja(String mestoOdrzavanja) {
        this.mestoOdrzavanja = mestoOdrzavanja;
    }

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public LocalDate getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(LocalDate datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Long getFormatId() {
        return formatId;
    }

    public void setFormatId(Long formatId) {
        this.formatId = formatId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
