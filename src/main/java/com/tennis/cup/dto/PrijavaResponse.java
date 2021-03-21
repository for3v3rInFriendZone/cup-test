package com.tennis.cup.dto;

import java.time.LocalDate;

/**
 * Koji ce se podaci vezano za Prijavu entity vratiti / prikazati na klijentu (React, Postman)
 */
public class PrijavaResponse {

    private Long id;

    private String drzavaTakmicara;

    private String kontaktEmail;

    private LocalDate datumPrijave;

    private String nazivTakmicenja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrzavaTakmicara() {
        return drzavaTakmicara;
    }

    public void setDrzavaTakmicara(String drzavaTakmicara) {
        this.drzavaTakmicara = drzavaTakmicara;
    }

    public String getKontaktEmail() {
        return kontaktEmail;
    }

    public void setKontaktEmail(String kontaktEmail) {
        this.kontaktEmail = kontaktEmail;
    }

    public LocalDate getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(LocalDate datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getNazivTakmicenja() {
        return nazivTakmicenja;
    }

    public void setNazivTakmicenja(String nazivTakmicenja) {
        this.nazivTakmicenja = nazivTakmicenja;
    }
}
