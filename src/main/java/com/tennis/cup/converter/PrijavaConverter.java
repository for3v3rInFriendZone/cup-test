package com.tennis.cup.converter;

import com.tennis.cup.dto.PrijavaRequest;
import com.tennis.cup.dto.PrijavaResponse;
import com.tennis.cup.model.Prijava;
import com.tennis.cup.model.Takmicenje;
import com.tennis.cup.repository.TakmicenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrijavaConverter {

    @Autowired
    private TakmicenjeRepository takmicenjeRepository;

    public Prijava toPrijava(PrijavaRequest novaPrijava) {
        Prijava prijava = new Prijava();

        prijava.setDatumPrijave(novaPrijava.getDatumPrijave());
        prijava.setDrzavaTakmicara(novaPrijava.getDrzavaTakmicara());
        prijava.setKontaktEmail(novaPrijava.getKontaktEmail());
        // Posto Prijava entity za bazu koristi Takmicenje objekat, moramo naci Takmicenje po id-ju koje je poslato od strane
        // React klijenta
        Takmicenje takmicenje = takmicenjeRepository.getOne(novaPrijava.getTakmicenjeId());

        prijava.setTakmicenje(takmicenje);

        return prijava;
    }

    public PrijavaResponse toPrijavaResponse(Prijava prijava) {
        PrijavaResponse prijavaResponse = new PrijavaResponse();
        prijavaResponse.setId(prijava.getId());
        prijavaResponse.setDatumPrijave(prijava.getDatumPrijave());
        prijavaResponse.setDrzavaTakmicara(prijava.getDrzavaTakmicara());
        prijavaResponse.setKontaktEmail(prijava.getKontaktEmail());
        prijavaResponse.setNazivTakmicenja(prijava.getTakmicenje().getNaziv());

        return prijavaResponse;
    }

}
