package com.example.projet1.service;

import com.example.projet1.model.Produit;
import com.example.projet1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    //enregistrer un produit
    public void saveProduit(Produit produit) {
        produitRepository.save(produit);
    }

    //afficher liste de produits
    public List<Produit> showProduits() {
        return produitRepository.findAll();
    }

    //Recherche de produit
    public List<Produit> rechercheProduit(String libelle) {
        List<Produit> optional = produitRepository.findAllByLibelle(libelle);
        List<Produit> listeProduit = null;
        if (optional.isEmpty()) {
            throw new RuntimeException("Produit introuvable");
        } else {
            listeProduit = optional;
        }
        return listeProduit;
    }

    //trouver un produit précis
    public Produit showOneProduit(int id) {
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;
        if (optional.isPresent()) {
            produit = optional.get();
        } else
            throw new RuntimeException("id introuvable");

        return produit;
    }

    //supprimer un produit
    public void deleteProduit(int id) {
        produitRepository.deleteById(id);
    }

    public List<Produit> produitDessousStock() {
        return produitRepository.findAllDessousStock();
    }

    public List<Produit> produitDispoStock() {
        return produitRepository.findProdDispo();
    }


}
