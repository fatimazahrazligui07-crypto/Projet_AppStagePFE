package com.jeem1.gestionpfe.repositories;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.jeem1.gestionpfe.entities.Etudiant;
import java.util.*;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
 Etudiant findByCne(String cne);
 List<Etudiant> findByFiliereId (Long filiereId);
 
}
