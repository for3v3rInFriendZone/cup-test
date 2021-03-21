package com.tennis.cup.service;

import com.tennis.cup.model.Takmicenje;
import java.util.List;

/**
 * Ovde definisemo sta nam se trazi za Takmicenje API u tekstu zadatka.
 * Treba dovuci sva Takmicenja, ali tako da ne dovucemo sve odjednom, vec da ide paginirano Prethodna i Sledeca
 * Dovuci jedno Takmicenje po njegovom Id-ju
 * Napraviti novo Takmicenje
 * Obrisati specificno Takmicenje
 */
public interface TakmicenjeService {

    List<Takmicenje> findAll(Integer pageNo, Integer pageSize);

    Takmicenje findOneById(Long id);

    Takmicenje save(Takmicenje takmicenje);

    void delete(Long id);
}
