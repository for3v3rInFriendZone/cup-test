package com.tennis.cup.repository;

import com.tennis.cup.model.Takmicenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long> {
    // Sve potrebne osnovne metode za rad sa bazom se nalaze u JpaRepository
}
