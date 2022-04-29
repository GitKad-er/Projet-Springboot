package com.example.projet1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lignevente")
public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantite;
    private double prix;

    @ManyToOne()
    @JoinColumn(name = "produitId", insertable = false, updatable = false)
    private Produit produit;
    private int produitId;

    @ManyToOne()
    @JoinColumn(name = "venteId", insertable = false, updatable = false)
    private Vente vente;
    private int venteId;
}
