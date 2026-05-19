package com.jeem1.gestionpfe.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Data
@Table(name="entreprises")
public class Entreprise {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
  private String nom;
  private String adresse;
  private String telephone;
  private String email;
  private String ville;
  private String pays;
  private String emailResponsable;
  private String emailEncadrant;
  private String telEncadrant;
  @JsonIgnore
  @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
  private List<Stage> stages = new ArrayList<>();
  
  
  
  
}
