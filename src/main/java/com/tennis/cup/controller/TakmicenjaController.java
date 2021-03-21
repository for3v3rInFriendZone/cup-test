package com.tennis.cup.controller;

import com.tennis.cup.converter.TakmicenjeDtoConverter;
import com.tennis.cup.dto.TakmicenjeRequest;
import com.tennis.cup.dto.TakmicenjeResponse;
import com.tennis.cup.model.Takmicenje;
import com.tennis.cup.service.TakmicenjeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/takmicenja")
@Validated
public class TakmicenjaController {

    @Autowired
    private TakmicenjeService takmicenjeService;

    @Autowired
    private TakmicenjeDtoConverter converter;

    @GetMapping
    // URL: GET localhost:8080/api/takmicenja
    // Ako zelis da promenis pageNo i pageSize, posto imaju default vrednost
    // Onda je URL: localhost:8080/api/takmicenja?pageNo=1&pageSize=5
    // Moze se slati samo pageNo ili samo pageSize, koji god da se NE POSALJE, imace vrednost koja je definisana kao defaultValue
    public List<TakmicenjeResponse> getAll(
        @RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        // Da bi mogli da radimo paginaciju, moramo na ovaj API da posaljemo dve vrednosti
        // Prva je pageNumber ili pageNo, a druga je pageSize
        // Ovo salje React klijent, da bi mogao da radi Prethodna i Sledeca funkcionalnost
        List<Takmicenje> takmicenja = takmicenjeService.findAll(pageNo, pageSize);

        return converter.toTakmicenjeResponse(takmicenja);
    }

    @GetMapping("/{id}")
    // URL: GET localhost:8080/api/takmicenja/1
    public ResponseEntity<TakmicenjeResponse> getOne(@PathVariable Long id) {
        Takmicenje takmicenjeIzBaze = takmicenjeService.findOneById(id);

        // Ako ne postoji Takmicenje sa zadatim id-jem, vratiti 404 NOT_FOUND
        if (takmicenjeIzBaze == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        TakmicenjeResponse takmicenjeDto = converter.toTakmicenjeDto(takmicenjeIzBaze);

        return ResponseEntity.ok(takmicenjeDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // URL: POST localhost:8080/api/takmicenja
    public TakmicenjeResponse create(@RequestBody @Valid TakmicenjeRequest takmicenjeDto) {
        Takmicenje takmicenjeZaSacuvati = converter.toTakmicenje(takmicenjeDto);
        Takmicenje novoTakmicenje = takmicenjeService.save(takmicenjeZaSacuvati);

        return converter.toTakmicenjeDto(novoTakmicenje);
    }

    @PutMapping("/{id}")
    // URL: PUT localhost:8080/api/takmicenja/1
    // Update Takmicenja je malo specifican, jer se salje tacno koje Takmicenje treba da se update-uje
    // pomocu id vrednosti i ceo novi objekat TakmicenjeRequest koje zapravo sadrzi podatke koji ce zameniti stare vrednosti
    public ResponseEntity<TakmicenjeResponse> update(@PathVariable Long id,
        @RequestBody @Valid TakmicenjeRequest takmicenjeDto) {

        if (!id.equals(takmicenjeDto.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Takmicenje takmicenjeZaSacuvati = converter.toTakmicenje(takmicenjeDto);
        Takmicenje novoTakmicenje = takmicenjeService.save(takmicenjeZaSacuvati);

        return ResponseEntity.ok(converter.toTakmicenjeDto(novoTakmicenje));
    }

    @DeleteMapping("/{id}")
    // URL: DELETE localhost:8080/api/takmicenja/1
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Takmicenje takmicenje = takmicenjeService.findOneById(id);

        // Ako ne postoji Takmicenje sa zadatim id-jem, vratiti 404 NOT_FOUND
        if (takmicenje == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        takmicenjeService.delete(id);

        // Obicno se nakon brisanja nekog entity-ja vraca 204 - NO_CONTENT ali moze i 200 - OK
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
