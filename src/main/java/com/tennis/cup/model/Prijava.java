package com.tennis.cup.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prijava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drzava_takmicara", nullable = false)
    private String drzavaTakmicara;

    @Column(name = "kontakt_email", nullable = false, unique = true)
    private String kontaktEmail;

    @Column(name = "datum_prijave", nullable = false)
    private LocalDate datumPrijave;

    @ManyToOne
    private Takmicenje takmicenje;

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

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }
}
