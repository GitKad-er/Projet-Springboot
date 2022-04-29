package com.example.projet1.controller;

import com.example.projet1.model.LigneVente;
import com.example.projet1.model.Produit;
import com.example.projet1.model.Vente;
import com.example.projet1.service.LigneVenteService;
import com.example.projet1.service.ProduitService;
import com.example.projet1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/LigneVentes")
public class LigneVenteController {
    @Autowired
    LigneVenteService ligneVenteService;
    @Autowired
    ProduitService produitService;
    @Autowired
    VenteService venteService;

    @GetMapping("/afficher")
    public String displayProduct(Model model) {
        model.addAttribute("listeslignesventes", ligneVenteService.showLigneVentes());
        return "LigneVentes/showLigneVente";
    }

    @GetMapping("/formLigneVente")
    public String formLigneVente() {
        return "LigneVentes/formLigneVente";
    }

    @GetMapping("/selectionProduit")
    public String selectionProduit(Model model) {
        model.addAttribute("listproduits", produitService.produitDispoStock());
        return "LigneVentes/selectionProduit";
    }
    /*@GetMapping("/rechercheSelection")
    public String rechercheSelection() {
        return "Ligneventes/rechercheSelection";
    }*/

    @PostMapping("save")
    public String saveLigneVente(LigneVente ligneVente, RedirectAttributes redirectAttributes) {
        Vente vente = venteService.showOneVente(venteService.derniereVente());
        redirectAttributes.addAttribute("idVen", vente.getId());
        if (ligneVente.getQuantite() > produitService.showOneProduit(ligneVente.getProduitId()).getQtStock()) {
            int idProd = ligneVente.getProduitId();
            return "approvisionnements/approvisionner/{idVen}";
        } else {
            Produit produit = produitService.showOneProduit(ligneVente.getProduitId());
            produit.setQtStock(produit.getQtStock() - ligneVente.getQuantite());
            produitService.saveProduit(produit);
            ligneVente.setPrix(produit.getPrix() * ligneVente.getQuantite());
            ligneVente.setVenteId(venteService.derniereVente());
            ligneVenteService.saveLigneVente(ligneVente);
            vente.setTotalVente(ligneVenteService.sumLigneVente(vente.getId()));
            venteService.saveVente(vente);
            return "redirect:/Ventes/details/{idVen}";
        }

    }

    @GetMapping("/vendre/{id}")
    public String FormEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        System.out.println("id = " + produitService.showOneProduit(id));
        return "LigneVentes/formLigneVente";
    }


    @GetMapping("delete/{id}")
    public String deleteLigneVete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        LigneVente ligneVente = ligneVenteService.ShowOneLigneVente(id);
        redirectAttributes.addAttribute("idVen", ligneVente.getVenteId());
        int idVen = ligneVente.getVenteId();
        ligneVenteService.deleteALigneVente(id);
        Vente vente = venteService.showOneVente(idVen);
        vente.setTotalVente(ligneVenteService.sumLigneVente(vente.getId()));
        venteService.saveVente(vente);
        return "redirect:/Ventes/details/{idVen}";
    }

    @PostMapping("recherche")
    public String rechercheProduit(@RequestParam("libelle") String libelle, Model model) {
        model.addAttribute("listproduits", produitService.rechercheProduit(libelle));
        System.out.println(produitService.rechercheProduit(libelle));
        return "LigneVentes/rechercheSelection";
    }


}
