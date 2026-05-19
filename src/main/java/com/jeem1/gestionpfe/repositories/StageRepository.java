package com.jeem1.gestionpfe.repositories;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.jeem1.gestionpfe.entities.Stage;
import java.util.*;
@Repository
public interface StageRepository extends JpaRepository <Stage, Long>{
	List<Stage> findByEntrepriseId(Long entrepriseId);
	List<Stage> findByEncadrantAcademiqueId(Long encadrantId);
	List<Stage> findByEtudiantFiliereId(Long filiereId);
	
	

}
