package com.example.projet1.service;

import com.example.projet1.model.Categorie;
import com.example.projet1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    //enregistrer une categorie
    public void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    //afficher liste de categorie
    public List<Categorie> showCategories(){
        return categorieRepository.findAll();
    }

    //trouver une categorie spécifique
    public Categorie showOneCategorie(int id){
        return categorieRepository.findById(id).get();
    }

    //supprimer une categorie
    public void deleteCategorie(int id)
    {
        categorieRepository.deleteById(id);
    }
}
