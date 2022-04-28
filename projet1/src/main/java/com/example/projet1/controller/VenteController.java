package com.example.projet1.controller;

import com.example.projet1.model.Vente;
import com.example.projet1.service.LigneVenteService;
import com.example.projet1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/ventes")
public class VenteController {

    @Autowired
    VenteService venteService;
    @Autowired
    LigneVenteService ligneVenteService;

    @GetMapping("/afficher")
    public String displayProduct(Model model) {
        model.addAttribute("listeVentes", venteService.showVentes());
        return "vente/showVente";
    }

    @PostMapping("/save")
    public String saveVente(Vente vente) {
        vente.setTotalVente(ligneVenteService.sumLigneVente(vente.getId()));
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        return "redirect:/ventes/afficher";

    }

    @GetMapping("edit/{id}")
    public String FormEditVente(@PathVariable("id") int id, Model model) {
        model.addAttribute("UneVente", venteService.showOneVente(id));
        return "/vente/formEdit";
    }

    @PostMapping("/edit")
    public String editVente(@ModelAttribute("vente") Vente vente) {
        venteService.saveVente(vente);
        return "redirect:/ventes/afficher";
    }

    @GetMapping("details/{id}")
    public String FormDetailVente(@PathVariable("id") int id, Model model) {
        model.addAttribute("UneVente", venteService.showOneVente(id));
        model.addAttribute("listesVentes", ligneVenteService.showLigneVenteParVente(id));
        return "/vente/formDetail";
    }

}
