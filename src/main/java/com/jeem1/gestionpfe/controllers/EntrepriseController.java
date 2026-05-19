package com.jeem1.gestionpfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeem1.gestionpfe.entities.Entreprise;
import com.jeem1.gestionpfe.services.EntrepriseService;
import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping
    public List<Entreprise> getAll() { return entrepriseService.getAll(); }

    @GetMapping("/{id}")
    public Entreprise getById(@PathVariable Long id) { return entrepriseService.getById(id); }

    @PostMapping
    public Entreprise save(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }

    @PutMapping("/{id}")
    public Entreprise update(@PathVariable Long id, @RequestBody Entreprise entreprise) {
        entreprise.setId(id);
        return entrepriseService.save(entreprise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { entrepriseService.delete(id); }
}