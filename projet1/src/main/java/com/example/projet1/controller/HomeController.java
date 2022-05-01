package com.example.projet1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String afficherHello() {
        return "produits/showProduit";
    }
}
