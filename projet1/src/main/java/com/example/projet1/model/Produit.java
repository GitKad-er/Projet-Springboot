package com.example.projet1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "categorie")
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private int qtStock;
    private int qtSeuil;
    private int prix;
    private LocalDate dateCreation;
    @ManyToOne()
    @JoinColumn(name = "categorieId", insertable = false, updatable = false)
    private Categorie categorie;
    private int categorieId;

    @OneToMany(mappedBy = "produit")
    private List<Approvisionnement> approvisionnements;

    @OneToMany(mappedBy = "produit")
    private List<LigneVente> ligneVentes;

    //ToString.Exclude();
}

