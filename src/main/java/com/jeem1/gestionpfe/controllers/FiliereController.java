package com.jeem1.gestionpfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeem1.gestionpfe.entities.Filiere;
import com.jeem1.gestionpfe.services.FiliereService;
import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public List<Filiere> getAll() { return filiereService.getAll(); }

    @GetMapping("/{id}")
    public Filiere getById(@PathVariable Long id) { return filiereService.getById(id); }

    @PostMapping
    public Filiere save(@RequestBody Filiere filiere) { return filiereService.save(filiere); }

    @PutMapping("/{id}")
    public Filiere update(@PathVariable Long id, @RequestBody Filiere filiere) {
        filiere.setId(id);
        return filiereService.save(filiere);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { filiereService.delete(id); }
}