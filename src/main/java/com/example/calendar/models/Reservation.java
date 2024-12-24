package com.example.calendar.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;



    public Long getId() {
        return id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Espace getEspace() {
        return espace;
    }
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Espace espace;
}
