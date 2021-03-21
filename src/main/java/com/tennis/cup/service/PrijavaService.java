package com.tennis.cup.service;

import com.tennis.cup.model.Prijava;

/**
 * Ovde definisemo sta nam se trazi za Prijavu API u tekstu zadatka. Treba samo napraviti da se sacuva nova Prijava
 */
public interface PrijavaService {

    Prijava save(Prijava novaPrijava);
}
