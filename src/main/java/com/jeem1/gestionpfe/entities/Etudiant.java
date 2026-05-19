package com.jeem1.gestionpfe.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Getter

@Setter
@Table(name="etudiants")
public class Etudiant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
private Long id;
private String cne;
private String nom;
private String prenom;
private String email;
private String tel;

@ManyToOne
@JoinColumn(name="filiere_id")
private Filiere filiere;
@JsonIgnore
@OneToOne(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
private Stage stage;
 


}
