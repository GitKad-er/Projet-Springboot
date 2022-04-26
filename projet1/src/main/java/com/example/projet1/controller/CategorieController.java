package com.example.projet1.controller;

import com.example.projet1.model.Categorie;
import com.example.projet1.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/Categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/afficher")
    public String ShowListCategorie(Model model) {
        model.addAttribute("ListCategories", categorieService.showCategories());
        System.out.println(categorieService.showCategories());
        return "Categorie/showCategorie";
    }

    @GetMapping("/formCategorie")
    public String formCategorie() {
        return "Categorie/formCategorie";
    }

    @PostMapping("/save")
    public String saveCategorie(Categorie categorie, RedirectAttributes redirectAttributes) {
        categorieService.saveCategorie(categorie);
        return "redirect:/Categorie/afficher";
    }

    @GetMapping("/edit/{id}")
    public String editFormCategorie(@PathVariable("id") int id, Model model) {
        model.addAttribute("uneCategorie", categorieService.showOneCategorie(id));
        return "Categorie/formEditCategorie";
    }

    @PostMapping("/edit")
    public String editCategorie(@ModelAttribute("Categorie") Categorie categorie) {
        categorieService.saveCategorie(categorie);
        return "redirect:/Categorie/afficher";
    }


    @GetMapping("delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id) {
        categorieService.deleteCategorie(id);
        return "redirect:/Categorie/afficher";
    }


}
