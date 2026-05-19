package com.jeem1.gestionpfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeem1.gestionpfe.entities.Entreprise;
import com.jeem1.gestionpfe.repositories.EntrepriseRepository;
import java.util.List;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepo;

    public List<Entreprise> getAll() { return entrepriseRepo.findAll(); }

    public Entreprise getById(Long id) {
        return entrepriseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));
    }

    public Entreprise save(Entreprise entreprise) { return entrepriseRepo.save(entreprise); }

    public void delete(Long id) { entrepriseRepo.deleteById(id); }
}