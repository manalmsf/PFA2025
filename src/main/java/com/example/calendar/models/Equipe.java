package com.example.calendar.models;

import jakarta.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;  // Le nom de l'équipe

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Utilisateur> membres;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Utilisateur> getMembres() {
        return Collections.unmodifiableList(membres);  // Collection non modifiable
    }

    public void setMembres(List<Utilisateur> membres) {
        this.membres = membres;
    }
}
