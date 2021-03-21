package com.tennis.cup.controller;

import com.tennis.cup.converter.PrijavaConverter;
import com.tennis.cup.dto.PrijavaRequest;
import com.tennis.cup.dto.PrijavaResponse;
import com.tennis.cup.model.Prijava;
import com.tennis.cup.service.PrijavaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prijave")
@Validated
public class PrijavaController {

    @Autowired
    private PrijavaService prijavaService;

    @Autowired
    private PrijavaConverter prijavaConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // Kada se salje zahtev da se napravi novi entity, u ovom slucaju, nova Prijava
    // NIKAKOOOOO NE ZABORAVITI @RequestBody da se stavi levo od Request objekta, odnosno od podataka koji su
    // dosli od strane React klijenta da bi se napravila nova Prijava
    public PrijavaResponse create(@RequestBody @Valid PrijavaRequest novaPrijavaRequest) {
        Prijava novaPrijava = prijavaService.save(prijavaConverter.toPrijava(novaPrijavaRequest));

        // Praksa je da kada se napravi novi entity, da se taj novo napravljen vrati kao response.
        return prijavaConverter.toPrijavaResponse(novaPrijava);
    }
}
