package com.tennis.cup.repository;

import com.tennis.cup.model.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {
    // Sve potrebne osnovne metode za rad sa bazom se nalaze u JpaRepository
}
