package com.tennis.cup.dto;

import com.tennis.cup.model.Takmicenje;
import com.tennis.cup.model.TipTakmicenja;
import java.util.List;

/**
 * Koji ce se podaci vezano za Format entity vratiti / prikazati na klijentu (React, Postman)
 */
public class FormatResponse {

    private Long id;

    private TipTakmicenja tipTakmicenja;

    private Integer brojUcesnik;

    private List<TakmicenjeResponse> takmicenja;

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

    public List<TakmicenjeResponse> getTakmicenja() {
        return takmicenja;
    }

    public void setTakmicenja(List<TakmicenjeResponse> takmicenja) {
        this.takmicenja = takmicenja;
    }
}
