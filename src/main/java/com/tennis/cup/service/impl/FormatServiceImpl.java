package com.tennis.cup.service.impl;

import com.tennis.cup.model.Format;
import com.tennis.cup.repository.FormatRepository;
import com.tennis.cup.service.FormatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceImpl implements FormatService {

    // Trazimo instancu FormatRepository-ja iz Spring dependency kontejnera
    @Autowired
    private FormatRepository formatRepository;

    @Override
    public List<Format> findAll() {
        // Prosto vratimo sve Formate iz baze koristeci repository findAll metodu koju imamo napisanu za nas od strane Spring-a
        // Ovo zapravo radi kao da si napisala SELECT * FROM format;
        return formatRepository.findAll();
    }
}
