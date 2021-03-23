package com.tennis.cup.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Takmicenje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv", nullable = false, unique = true)
    private String naziv;

    @Column(name = "mesto_odrzavanja", nullable = false)
    private String mestoOdrzavanja;

    @Column(name = "datum_pocetka", nullable = false)
    private LocalDate datumPocetka;

    @Column(name = "datum_zavrsetka", nullable = false)
    private LocalDate datumZavrsetka;

    @ManyToOne
    private Format format;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "takmicenje", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Prijava> prijave;

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

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public List<Prijava> getPrijave() {
        return prijave;
    }

    public void setPrijave(List<Prijava> prijave) {
        this.prijave = prijave;
    }
}
