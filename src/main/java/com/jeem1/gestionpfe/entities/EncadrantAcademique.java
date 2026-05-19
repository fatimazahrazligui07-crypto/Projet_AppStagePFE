package com.jeem1.gestionpfe.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Data
@Table(name="encadrants_academiques")
public class EncadrantAcademique {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nom;
private String departement;
private String etablissement;
@JsonIgnore
@OneToMany(mappedBy="encadrantAcademique", cascade=CascadeType.ALL)
private List<Stage> stages = new ArrayList<>();
}
