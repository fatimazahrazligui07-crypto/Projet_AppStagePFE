package com.jeem1.gestionpfe.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Data
@Table(name = "filieres")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    @JsonIgnore
    @OneToOne(mappedBy = "filiere", cascade = CascadeType.ALL)
    private ResponsableFiliere responsable;
    @JsonIgnore
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants = new ArrayList<>();
}