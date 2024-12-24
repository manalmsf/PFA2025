package com.example.calendar.services;

import com.example.calendar.models.Utilisateur;
import com.example.calendar.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id: " + id));
    }


    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }


    public Utilisateur updateUtilisateur(int id, Utilisateur updatedUtilisateur) {
        Utilisateur existingUtilisateur = getUtilisateurById(id);
        existingUtilisateur.setNom(updatedUtilisateur.getNom());
        existingUtilisateur.setEmail(updatedUtilisateur.getEmail());
        existingUtilisateur.setMotDePasse(updatedUtilisateur.getMotDePasse());
        return utilisateurRepository.save(existingUtilisateur);
    }


    public void deleteUtilisateur(int id) {
        utilisateurRepository.deleteById(id);
    }
}