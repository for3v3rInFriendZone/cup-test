package com.tennis.cup.converter;

import com.tennis.cup.dto.TakmicenjeResponse;
import com.tennis.cup.dto.TakmicenjeRequest;
import com.tennis.cup.model.Format;
import com.tennis.cup.model.Takmicenje;
import com.tennis.cup.repository.FormatRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TakmicenjeDtoConverter {

    @Autowired
    private FormatRepository formatRepository;

    public TakmicenjeResponse toTakmicenjeDto(Takmicenje takmicenje) {
        TakmicenjeResponse takmicenjeDto = new TakmicenjeResponse();
        takmicenjeDto.setId(takmicenje.getId());
        takmicenjeDto.setDatumPocetka(takmicenje.getDatumPocetka());
        takmicenjeDto.setDatumZavrsetka(takmicenje.getDatumZavrsetka());
        takmicenjeDto.setTipTakmicenja(takmicenje.getFormat().getTipTakmicenja());
        takmicenjeDto.setBrojUcesnika(takmicenje.getFormat().getBrojUcesnik());
        takmicenjeDto.setNaziv(takmicenje.getNaziv());
        takmicenjeDto.setMestoOdrzavanja(takmicenje.getMestoOdrzavanja());

        return takmicenjeDto;
    }

    public Takmicenje toTakmicenje(TakmicenjeRequest takmicenjeDto) {
        Takmicenje takmicenje = new Takmicenje();
        takmicenje.setDatumPocetka(takmicenjeDto.getDatumPocetka());
        takmicenje.setDatumZavrsetka(takmicenjeDto.getDatumZavrsetka());
        takmicenje.setNaziv(takmicenjeDto.getNaziv());
        takmicenje.setMestoOdrzavanja(takmicenjeDto.getMestoOdrzavanja());
        takmicenje.setId(takmicenjeDto.getId());

        Format format = formatRepository.getOne(takmicenjeDto.getFormatId());

        takmicenje.setFormat(format);

        return takmicenje;
    }

    public List<TakmicenjeResponse> toTakmicenjeResponse(List<Takmicenje> takmicenjaIzBaze) {
        List<TakmicenjeResponse> takmicenjaZaKlijenta = new ArrayList<>();

        for (Takmicenje takmicenjeIzBaze : takmicenjaIzBaze) {
            takmicenjaZaKlijenta.add(toTakmicenjeDto(takmicenjeIzBaze));
        }

        return takmicenjaZaKlijenta;
    }
}
