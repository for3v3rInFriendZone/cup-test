package com.tennis.cup.repository;

import com.tennis.cup.model.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long> {
    // Sve potrebne osnovne metode za rad sa bazom se nalaze u JpaRepository
}
