package com.tennis.cup.dto;

import java.time.LocalDate;
import org.hibernate.validator.constraints.Length;

/**
 * Klasa koja definise vrednosti neophodne da bi se napravila nova Prijava (ovo salju klijenti kao sto su React ili Postman)
 * Salje se JSON, koji posle Jackson biblioteka koja se nalazi u Spring-u mapira na ovaj objekat.
 */
public class PrijavaRequest {

    // Drzava takmicara mora da ima tacno tri karaktera
    @Length(min = 3, max = 3)
    private String drzavaTakmicara;

    private String kontaktEmail;

    private LocalDate datumPrijave;

    // Salje se takmicnenjeId, da bi se znalo kom Takmicenju prijava pripada
    private Long takmicenjeId;

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

    public Long getTakmicenjeId() {
        return takmicenjeId;
    }

    public void setTakmicenjeId(Long takmicenjeId) {
        this.takmicenjeId = takmicenjeId;
    }
}
