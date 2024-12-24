package com.example.calendar.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Espace {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nom;
  private String type;
  private String capacite;
  private String equipement;
  public Boolean estDispo;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCapacite() {
    return capacite;
  }

  public void setCapacite(String capacite) {
    this.capacite = capacite;
  }

  public String getEquipement() {
    return equipement;
  }

  public void setEquipement(String equipement) {
    this.equipement = equipement;
  }

  public Boolean getEstDispo() {
    return estDispo;
  }

  public void setEstDispo(Boolean estDispo) {
    this.estDispo = estDispo;
  }

  @OneToMany(mappedBy = "espace")
  private Set<Reservation> reservations;
}
