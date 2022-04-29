package com.example.projet1.service;


import com.example.projet1.model.Vente;
import com.example.projet1.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    //enregistrer une vente
    public void saveVente(Vente vente) {
        venteRepository.save(vente);
    }

    //afficher la liste de ventes
    public List<Vente> showVentes() {
        return venteRepository.findAll();
    }

    //retrouver une vente spécifique
    public Vente showOneVente(int id) {
        return venteRepository.findById(id).get();
    }

    //supprimer une vente
    public void deleteVente(int id) {
        venteRepository.deleteById(id);
    }

    public int derniereVente() {
        return venteRepository.findByMaxid();
    }

}
