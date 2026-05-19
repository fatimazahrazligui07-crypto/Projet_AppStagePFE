package com.jeem1.gestionpfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeem1.gestionpfe.entities.*;
import com.jeem1.gestionpfe.repositories.*;
import java.util.List;

@Service
public class StageService {

    @Autowired private StageRepository stageRepo;
    @Autowired private EtudiantRepository etudiantRepo;
    @Autowired private EntrepriseRepository entrepriseRepo;
    @Autowired private EncadrantAcademiqueRepository encadrantRepo;

    //public List<Stage> getAll() { return stageRepo.findAll(); }
    @Transactional(readOnly = true)
    public List<Stage> getAll() { 
        return stageRepo.findAll(); 
    }
    
    public Stage getById(Long id) {
        return stageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage introuvable"));
    }

    // Ajout et modification d'un stage
    @Transactional
    public Stage save(Stage stage, Long etudiantId, Long entrepriseId, Long encadrantId) {
    	 System.out.println("Début save - EtudiantID: " + etudiantId);
        Etudiant etudiant = etudiantRepo.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        Entreprise entreprise = entrepriseRepo.findById(entrepriseId)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        EncadrantAcademique encadrant = encadrantRepo.findById(encadrantId)
                .orElseThrow(() -> new RuntimeException("Encadrant introuvable"));

        // Affectation du sujet à l'étudiant
        stage.setEtudiant(etudiant);
        // Attribution de l'encadrant académique
        stage.setEncadrantAcademique(encadrant);
        // Attribution de l'entreprise
        stage.setEntreprise(entreprise);

        return stageRepo.save(stage);
    }

    // Suppression d'un stage
    @Transactional
    public void delete(Long id) {
        Stage stage = stageRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Stage introuvable"));

        // Casser la référence côté Etudiant
        Etudiant etudiant = stage.getEtudiant();
        if (etudiant != null) {
            etudiant.setStage(null);
            etudiantRepo.save(etudiant);
        }

        stageRepo.deleteById(id);
    }
    // Consultation des stages par filière
    public List<Stage> getByFiliere(Long filiereId) {
        return stageRepo.findByEtudiantFiliereId(filiereId);
    }

    // Consultation des stages par encadrant
    public List<Stage> getByEncadrant(Long encadrantId) {
        return stageRepo.findByEncadrantAcademiqueId(encadrantId);
    }

    // Consultation des stages par entreprise
    public List<Stage> getByEntreprise(Long entrepriseId) {
        return stageRepo.findByEntrepriseId(entrepriseId);
    }
    @Transactional
    public Stage update(Long id, Stage stage, Long etudiantId, Long entrepriseId, Long encadrantId) {
        Stage existing = stageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage introuvable"));

        Etudiant etudiant = etudiantRepo.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
        Entreprise entreprise = entrepriseRepo.findById(entrepriseId)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));
        EncadrantAcademique encadrant = encadrantRepo.findById(encadrantId)
                .orElseThrow(() -> new RuntimeException("Encadrant introuvable"));

        existing.setSujet(stage.getSujet());
        existing.setDateDebut(stage.getDateDebut());
        existing.setEtudiant(etudiant);
        existing.setEntreprise(entreprise);
        existing.setEncadrantAcademique(encadrant);

        return stageRepo.save(existing);
    }
}