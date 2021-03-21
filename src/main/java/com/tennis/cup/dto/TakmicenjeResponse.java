package com.tennis.cup.dto;

import com.tennis.cup.model.TipTakmicenja;
import java.time.LocalDate;

/**
 * Vracamo specificne vrednosti iz Takmicenja, u zavisnosti od toga sta je potrebno da prikazemo na klientskoj strani
 * Tj. na React web stranici
 */
public class TakmicenjeResponse {

    private Long id;

    private String naziv;

    private String mestoOdrzavanja;

    private LocalDate datumPocetka;

    private LocalDate datumZavrsetka;

    private TipTakmicenja tipTakmicenja;

    private Integer brojUcesnika;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TipTakmicenja getTipTakmicenja() {
        return tipTakmicenja;
    }

    public void setTipTakmicenja(TipTakmicenja tipTakmicenja) {
        this.tipTakmicenja = tipTakmicenja;
    }

    public Integer getBrojUcesnika() {
        return brojUcesnika;
    }

    public void setBrojUcesnika(Integer brojUcesnika) {
        this.brojUcesnika = brojUcesnika;
    }
}
