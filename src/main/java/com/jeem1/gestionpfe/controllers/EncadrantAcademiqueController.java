package com.jeem1.gestionpfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeem1.gestionpfe.entities.EncadrantAcademique;
import com.jeem1.gestionpfe.services.EncadrantAcademiqueService;
import java.util.List;

@RestController
@RequestMapping("/api/encadrants")
public class EncadrantAcademiqueController {

    @Autowired
    private EncadrantAcademiqueService encadrantService;

    @GetMapping
    public List<EncadrantAcademique> getAll() { return encadrantService.getAll(); }

    @GetMapping("/{id}")
    public EncadrantAcademique getById(@PathVariable Long id) {
        return encadrantService.getById(id);
    }

    @PostMapping
    public EncadrantAcademique save(@RequestBody EncadrantAcademique encadrant) {
        return encadrantService.save(encadrant);
    }

    @PutMapping("/{id}")
    public EncadrantAcademique update(@PathVariable Long id,
                                      @RequestBody EncadrantAcademique encadrant) {
        encadrant.setId(id);
        return encadrantService.save(encadrant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { encadrantService.delete(id); }
}