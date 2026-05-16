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
    // Home-Seite
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", repo.findByApprovedTrue());
        return "index";
    }
    // Admin-Seite
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("data", repo.findAll());
        return "admin";
    }
    // Neue Daten hinzufügen
    @PostMapping("/admin/add")
    public String addEmission(CountryEmission emission) {

        emission.setApproved(false); // 🔥 wichtig fürs COULD-Feature
        repo.save(emission);

        return "redirect:/admin";
    }
    // Daten genehmigen
    @GetMapping("/admin/approve/{id}")
    public String approve(@PathVariable Long id) {

        CountryEmission emission = repo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));

        emission.setApproved(true);
        repo.save(emission);

        return "redirect:/admin";
    }
}