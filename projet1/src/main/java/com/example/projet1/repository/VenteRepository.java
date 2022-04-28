package com.example.projet1.repository;

import com.example.projet1.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

    List<Vente> findDistinctByDateVenteAfterAndDateVenteBefore(LocalDate dateDebut, LocalDate DateFin);
}