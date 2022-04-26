package com.example.projet1.controller;


import com.example.projet1.model.Produit;
import com.example.projet1.service.CategorieService;
import com.example.projet1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public String displayProduct(Model model) {
        model.addAttribute("listproduits", produitService.showProduits());
        return "produits/showProduit";
    }

    @GetMapping("/form")
    public String renseigner(Model model) {
        model.addAttribute("listCategories", categorieService.showCategories());
        return "produits/saveProduit";
    }

    @PostMapping("/save")
    public String saveProduit(Produit produit) {

        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        model.addAttribute("UneCategorie", categorieService.showCategories());
        return "/produits/formEdit";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit) {
        produitService.saveProduit((produit));
        return "redirect:/produits/afficher";
    }


    @GetMapping("delete/{id}")
    public String deleteProduit(@PathVariable("id") int id) {
        produitService.deleteProduit(id);
        return "redirect:/produits/afficher";
    }


}

