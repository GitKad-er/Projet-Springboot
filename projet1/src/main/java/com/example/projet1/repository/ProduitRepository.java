package com.example.projet1.repository;

import com.example.projet1.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    @Query("select distinct p from Produit p where p.libelle like concat('%', :libelle, '%')")
    List<Produit> findAllByLibelle(@Param("libelle") String libelle);

}
