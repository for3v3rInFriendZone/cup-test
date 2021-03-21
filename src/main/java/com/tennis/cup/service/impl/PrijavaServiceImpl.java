package com.tennis.cup.service.impl;

import com.tennis.cup.model.Prijava;
import com.tennis.cup.repository.PrijavaRepository;
import com.tennis.cup.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrijavaServiceImpl implements PrijavaService {

    // Trazimo instancu PrijavaRepository-ja iz Spring dependency kontejnera
    @Autowired
    private PrijavaRepository prijavaRepository;

    @Override
    public Prijava save(Prijava novaPrijava) {

        // Pozivamo save metodu iz repository-ja da bi uneli novu Prijavu u bazu podataka
        // Save radi pravljenje novog reda u bazi, ali takodje radi i update.
        return prijavaRepository.save(novaPrijava);
    }
}
