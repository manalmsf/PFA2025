package com.example.calendar.services;

import com.example.calendar.models.Equipe;
import com.example.calendar.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


 @Service
public class EquipeService {

    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable avec l'ID : " + id));
    }
    public Equipe updateEquipe(Long id, Equipe updatedEquipe) {
        Equipe existingEquipe = getEquipeById(id);

        existingEquipe.setNom(updatedEquipe.getNom());
        existingEquipe.setMembres(updatedEquipe.getMembres());

        return equipeRepository.save(existingEquipe);
    }


    public void deleteEquipe(Long id) {
        if (!equipeRepository.existsById(id)) {
            throw new RuntimeException("Équipe introuvable avec l'ID : " + id);
        }
        equipeRepository.deleteById(id);
    }
}
