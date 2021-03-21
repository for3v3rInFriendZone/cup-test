package com.tennis.cup.service.impl;

import com.tennis.cup.model.Takmicenje;
import com.tennis.cup.repository.TakmicenjeRepository;
import com.tennis.cup.service.TakmicenjeService;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TakmicenjeServiceImpl implements TakmicenjeService {

    // Trazimo instancu PrijavaRepository-ja iz Spring dependency kontejnera
    @Autowired
    private TakmicenjeRepository takmicenjeRepository;

    @Override
    public List<Takmicenje> findAll(Integer pageNo, Integer pageSize) {
        // Ovo je nacin kako se radi paginacija.
        // Napravi se PageRequest na osnovu broja stranice i broja podataka koje zelimo da prikaezmo na jednoj stranici
        // Ovo ce slati React klijent i na osnovu toga mi mu vratimo podatke
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<Takmicenje> pagedResult = takmicenjeRepository.findAll(paging);

        // Ovo ce samo vratiti listu Takmicenja
        return pagedResult.getContent();
    }

    @Override
    public Takmicenje findOneById(Long id) {
        // Vratiti Takmicenje po id-ju, a ako ne postoji Takmicenje za taj Id, vratiti NULL vrednost.
        return takmicenjeRepository.findById(id)
            .orElse(null);
    }

    @Override
    public Takmicenje save(Takmicenje takmicenje) {
        // Pozivamo save metodu iz repository-ja da bi uneli novo Takmicenje u bazu podataka
        return takmicenjeRepository.save(takmicenje);
    }

    @Override
    public void delete(Long id) {
        // Brisemo Takmicenje iz baze po id-ju
        takmicenjeRepository.deleteById(id);
    }
}
