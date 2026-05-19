package com.jeem1.gestionpfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeem1.gestionpfe.entities.EncadrantAcademique;
import com.jeem1.gestionpfe.repositories.EncadrantAcademiqueRepository;
import java.util.List;

@Service
public class EncadrantAcademiqueService {

    @Autowired
    private EncadrantAcademiqueRepository encadrantRepo;

    public List<EncadrantAcademique> getAll() { return encadrantRepo.findAll(); }

    public EncadrantAcademique getById(Long id) {
        return encadrantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Encadrant introuvable"));
    }

    // Attribution des encadrants académiques
    public EncadrantAcademique save(EncadrantAcademique encadrant) {
        return encadrantRepo.save(encadrant);
    }

    public void delete(Long id) { encadrantRepo.deleteById(id); }

    public List<EncadrantAcademique> getByDepartement(String departement) {
        return encadrantRepo.findByDepartement(departement);
    }
}