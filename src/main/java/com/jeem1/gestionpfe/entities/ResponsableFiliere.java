package com.jeem1.gestionpfe.entities;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity 
@Data
@Table(name="responsables_filiere")
public class ResponsableFiliere {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nom;
private String prenom;
private String grade;
private String email;
private String tel;
@JsonIgnore
@OneToOne 
@JoinColumn(name ="filiere_id")
private Filiere filiere;

}
