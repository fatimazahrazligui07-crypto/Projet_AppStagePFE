package com.jeem1.gestionpfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeem1.gestionpfe.entities.Filiere;
import com.jeem1.gestionpfe.repositories.FiliereRepository;
import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepo;

    public List<Filiere> getAll() { return filiereRepo.findAll(); }

    public Filiere getById(Long id) {
        return filiereRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Filière introuvable"));
    }

    public Filiere save(Filiere filiere) { return filiereRepo.save(filiere); }

    public void delete(Long id) { filiereRepo.deleteById(id); }
}