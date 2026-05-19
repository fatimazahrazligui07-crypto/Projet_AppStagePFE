package com.jeem1.gestionpfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeem1.gestionpfe.entities.Etudiant;
import com.jeem1.gestionpfe.services.EtudiantService;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAll() { return etudiantService.getAll(); }

    @GetMapping("/{id}")
    public Etudiant getById(@PathVariable Long id) { return etudiantService.getById(id); }

    @PostMapping("/{filiereId}")
    public Etudiant save(@RequestBody Etudiant etudiant, @PathVariable Long filiereId) {
        return etudiantService.save(etudiant, filiereId);
    }

    @PutMapping("/{id}/{filiereId}")
    public Etudiant update(@PathVariable Long id, @PathVariable Long filiereId,
                           @RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantService.save(etudiant, filiereId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { etudiantService.delete(id); }

    @GetMapping("/filiere/{filiereId}")
    public List<Etudiant> getByFiliere(@PathVariable Long filiereId) {
        return etudiantService.getByFiliere(filiereId);
    }
}