package com.likehero.likeherotozero.controller;

import com.likehero.likeherotozero.model.CountryEmission;
import com.likehero.likeherotozero.repository.CountryEmissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emissions")
@CrossOrigin(origins = "*")
public class CountryEmissionController {

    private final CountryEmissionRepository repository;

    public CountryEmissionController(CountryEmissionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CountryEmission> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CountryEmission getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public CountryEmission create(@RequestBody CountryEmission emission) {
        return repository.save(emission);
    }
    @GetMapping("/country/{name}")
    public List<CountryEmission> getByCountry(@PathVariable String name) {
        return repository.findByCountry(name);
    }
}