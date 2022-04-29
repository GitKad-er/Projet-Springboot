package com.example.projet1.repository;

import com.example.projet1.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {


    @Query("select l from LigneVente l where l.venteId = ?1")
    List<LigneVente> findByVenteId(int id);

    @Query("select sum(l.prix) from LigneVente l where l.venteId = ?1")
    double sumVente(int id);

}
