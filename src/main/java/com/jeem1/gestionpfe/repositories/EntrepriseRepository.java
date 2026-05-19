package com.jeem1.gestionpfe.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jeem1.gestionpfe.entities.Entreprise;
import java.util.List;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
List<Entreprise> findByVille (String ville);
Entreprise findByNom(String nom);

}
