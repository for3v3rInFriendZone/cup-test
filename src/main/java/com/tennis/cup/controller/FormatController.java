package com.tennis.cup.controller;

import com.tennis.cup.converter.FormatDtoConverter;
import com.tennis.cup.dto.FormatResponse;
import com.tennis.cup.model.Format;
import com.tennis.cup.service.FormatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formati")
public class FormatController {

    @Autowired
    private FormatService formatService;

    @Autowired
    private FormatDtoConverter formatDtoConverter;

    @GetMapping
    public List<FormatResponse> findAll() {
        // Najcesci nacin - prvo dovucemo sve Formate iz baze, dakle sve entity Formate
        List<Format> formatiIzBaze = formatService.findAll();

        // I onda radimo convertovanje iz Entity objekta Format u FormatResponse, opet kazem
        // U zavisnosti od toga sta treba React klijent da prikaze od podataka na web stranici, to vracamo u obliku FormatResponse-a
        return formatDtoConverter.toFormatResponseList(formatiIzBaze);
    }
}
