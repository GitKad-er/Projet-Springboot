package com.example.projet1.service;


import com.example.projet1.model.LigneVente;
import com.example.projet1.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneVenteService {
    @Autowired
    LigneVenteRepository ligneVenteRepository;

    public void saveLigneVente(LigneVente ligneVente) {
        ligneVenteRepository.save(ligneVente);
    }

    public List<LigneVente> showLigneVentes() {
        return ligneVenteRepository.findAll();
    }

    public LigneVente ShowOneLigneVente(int id) {
        return ligneVenteRepository.findById(id).get();
    }

    public void deleteALigneVente(int id) {
        ligneVenteRepository.deleteById(id);
    }

    public double sumLigneVente(int id) {
        return ligneVenteRepository.sumVente(id);
    }

    public List<LigneVente> showLigneVenteParVente(int id) {
        return ligneVenteRepository.findByVenteId(id);
    }
}
