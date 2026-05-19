package com.jeem1.gestionpfe.repositories;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import  com.jeem1.gestionpfe.entities.ResponsableFiliere;

@Repository
public interface ResponsableFiliereRepository extends JpaRepository<ResponsableFiliere, Long> {
	ResponsableFiliere findByEmail(String email);
	
	
}
