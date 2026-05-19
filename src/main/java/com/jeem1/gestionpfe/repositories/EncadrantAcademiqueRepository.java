package com.jeem1.gestionpfe.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jeem1.gestionpfe.entities.EncadrantAcademique;
import java.util.List;

@Repository
public interface EncadrantAcademiqueRepository extends JpaRepository<EncadrantAcademique, Long> {
    List<EncadrantAcademique> findByDepartement(String departement);
    EncadrantAcademique findByNom(String nom);
}
