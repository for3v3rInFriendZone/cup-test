package com.tennis.cup.service;

import com.tennis.cup.model.Format;
import java.util.List;

/**
 * Ovde definisemo sta nam se trazi za Format API u tekstu zadatka. Dakle, samo da se dovuku svi formati iz baze.
 */
public interface FormatService {

    List<Format> findAll();
}
