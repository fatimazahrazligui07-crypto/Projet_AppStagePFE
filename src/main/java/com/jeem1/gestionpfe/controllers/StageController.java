package com.jeem1.gestionpfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeem1.gestionpfe.entities.Stage;
import com.jeem1.gestionpfe.services.StageService;
import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public List<Stage> getAll() { return stageService.getAll(); }

    @GetMapping("/{id}")
    public Stage getById(@PathVariable Long id) { return stageService.getById(id); }

    @PostMapping("/{etudiantId}/{entrepriseId}/{encadrantId}")
    public Stage save(@RequestBody Stage stage,
                      @PathVariable Long etudiantId,
                      @PathVariable Long entrepriseId,
                      @PathVariable Long encadrantId) {
        // On utilise directement les IDs reçus dans l'URL
        return stageService.save(stage, etudiantId, entrepriseId, encadrantId);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { stageService.delete(id); }

    @GetMapping("/filiere/{filiereId}")
    public List<Stage> getByFiliere(@PathVariable Long filiereId) {
        return stageService.getByFiliere(filiereId);
    }

    @GetMapping("/encadrant/{encadrantId}")
    public List<Stage> getByEncadrant(@PathVariable Long encadrantId) {
        return stageService.getByEncadrant(encadrantId);
    }
    @PutMapping("/{id}/{etudiantId}/{entrepriseId}/{encadrantId}")
    public Stage update(@PathVariable Long id,
                        @RequestBody Stage stage,
                        @PathVariable Long etudiantId,
                        @PathVariable Long entrepriseId,
                        @PathVariable Long encadrantId) {
        return stageService.update(id, stage, etudiantId, entrepriseId, encadrantId);
    }
}