package com.jeem1.gestionpfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeem1.gestionpfe.entities.Etudiant;
import com.jeem1.gestionpfe.entities.Filiere;
import com.jeem1.gestionpfe.repositories.EtudiantRepository;
import com.jeem1.gestionpfe.repositories.FiliereRepository;
import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepo;

    @Autowired
    private FiliereRepository filiereRepo;

    public List<Etudiant> getAll() { return etudiantRepo.findAll(); }

    public Etudiant getById(Long id) {
        return etudiantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
    }

    // Gestion des étudiants et affectation à une filière
    @Transactional
    public Etudiant save(Etudiant etudiant, Long filiereId) {
        Filiere filiere = filiereRepo.findById(filiereId)
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));
        etudiant.setFiliere(filiere);
        return etudiantRepo.save(etudiant);
    }

    public void delete(Long id) { etudiantRepo.deleteById(id); }

    // Consultation des étudiants par filière
    public List<Etudiant> getByFiliere(Long filiereId) {
        return etudiantRepo.findByFiliereId(filiereId);
    }
}