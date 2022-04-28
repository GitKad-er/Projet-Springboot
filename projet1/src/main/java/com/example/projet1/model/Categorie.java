package com.example.projet1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@Data
@ToString(exclude = "produits")
@NoArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String designation;
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

}
