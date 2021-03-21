package com.tennis.cup.converter;

import com.tennis.cup.dto.FormatResponse;
import com.tennis.cup.model.Format;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormatDtoConverter {

    @Autowired
    private TakmicenjeDtoConverter takmicenjeDtoConverter;

    public List<FormatResponse> toFormatResponseList(List<Format> formatiIzBaze) {
        List<FormatResponse> formatiZaKlijenta = new ArrayList<>();

        for (Format formatIzBaze : formatiIzBaze) {
            FormatResponse formatDto = new FormatResponse();
            formatDto.setId(formatIzBaze.getId());
            formatDto.setBrojUcesnik(formatIzBaze.getBrojUcesnik());
            formatDto.setTipTakmicenja(formatIzBaze.getTipTakmicenja());
            // Obratiti paznju na ovaj deo. FormatResponse klasa ima u sebi listu TakmicenjeResponse objekata.
            // Ono sluzi, da kada se vrate svi Formati, da se prikazu sva Takmicenja koja imaju taj Format.
            // Isto kao sto smo za FormatResponse stavili odredjene property-je, tako smo isto i za Takmicenje u okviru Formata.
            // Nismo vratili sve iz Takmicenja, vec ono sto smatramo da se treba da bude na toj web stranici za prikazivanje svih formata
            formatDto.setTakmicenja(
                takmicenjeDtoConverter.toTakmicenjeResponse(formatIzBaze.getTakmicenja()));

            formatiZaKlijenta.add(formatDto);
        }

        return formatiZaKlijenta;
    }

}
