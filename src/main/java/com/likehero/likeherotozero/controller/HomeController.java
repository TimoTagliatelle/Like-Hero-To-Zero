package com.likehero.likeherotozero.controller;

import com.likehero.likeherotozero.model.CountryEmission;
import com.likehero.likeherotozero.repository.CountryEmissionRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final CountryEmissionRepository repo;

    public HomeController(CountryEmissionRepository repo) {
        this.repo = repo;
    }

    // Startseite
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", repo.findAll());
        return "index";
    }
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("data", repo.findAll());
        return "admin";
    }
    @PostMapping("/admin/add")
    public String addEmission(CountryEmission emission) {

        repo.save(emission);

        return "redirect:/admin";
    }
}