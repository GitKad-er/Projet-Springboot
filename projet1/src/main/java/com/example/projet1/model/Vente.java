package com.example.projet1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventes")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelleVente;
    private double totalVente;
    private LocalDate dateVente;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;

    @ManyToOne()
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
    private int userId;

}
