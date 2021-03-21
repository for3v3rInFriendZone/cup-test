package com.tennis.cup.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tip_takmicenja", nullable = false)
    @Enumerated(EnumType.STRING)
    // Ako zelimo da nam Hibernate sacuva Enum u bazu kao String vrednost, treba staviti anotaciju levo
    private TipTakmicenja tipTakmicenja;

    @Column(name = "broj_ucesnika", nullable = false)
    private Integer brojUcesnik;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "format")
    private List<Takmicenje> takmicenja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipTakmicenja getTipTakmicenja() {
        return tipTakmicenja;
    }

    public void setTipTakmicenja(TipTakmicenja tipTakmicenja) {
        this.tipTakmicenja = tipTakmicenja;
    }

    public Integer getBrojUcesnik() {
        return brojUcesnik;
    }

    public void setBrojUcesnik(Integer brojUcesnik) {
        this.brojUcesnik = brojUcesnik;
    }

    public List<Takmicenje> getTakmicenja() {
        return takmicenja;
    }

    public void setTakmicenja(List<Takmicenje> takmicenja) {
        this.takmicenja = takmicenja;
    }
}
