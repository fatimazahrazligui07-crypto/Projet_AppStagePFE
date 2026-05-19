package com.jeem1.gestionpfe.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.jeem1.gestionpfe.entities.Filiere;

@Repository

public interface FiliereRepository extends JpaRepository<Filiere, Long> {
	
	Filiere findByIntitule(String intitule);
	
	
	
	
	

}
