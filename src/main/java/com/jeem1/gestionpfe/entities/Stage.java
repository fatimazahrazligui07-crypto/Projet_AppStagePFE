package com.jeem1.gestionpfe.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Data
@NoArgsConstructor  
@AllArgsConstructor 
@Table(name = "stages")
public class Stage {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String sujet;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFin; 
	@Column(columnDefinition="TEXT")
	private String description;
	@Column(columnDefinition = "TEXT")
    private String objectifs;

    @Column(columnDefinition = "TEXT")
    private String solution;

    @Column(columnDefinition = "TEXT")
    private String demarche;

    @Column(columnDefinition = "TEXT")
    private String outils;
    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "encadrant_academique_id")
    private EncadrantAcademique encadrantAcademique; 
    
    
    
    
    
    
}
