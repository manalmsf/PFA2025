package com.example.calendar.services;

import com.example.calendar.models.Espace;
import com.example.calendar.repositories.EspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspaceService {

    private final EspaceRepository espaceRepository;

    @Autowired
    public EspaceService(EspaceRepository espaceRepository) {
        this.espaceRepository = espaceRepository;
    }

    // Get all spaces
    public List<Espace> getAllEspaces() {
        return espaceRepository.findAll();
    }

    // Get space by ID
    public Espace getEspaceById(Long id) {
        return espaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espace not found with id: " + id));
    }

    // Create new space
    public Espace createEspace(Espace espace) {
        return espaceRepository.save(espace);
    }

    // Update space
    public Espace updateEspace(Long id, Espace updatedEspace) {
        Espace existingEspace = getEspaceById(id);
        existingEspace.setNom(updatedEspace.getNom());
        existingEspace.setCapacite(updatedEspace.getCapacite());
        return espaceRepository.save(existingEspace);
    }

    // Delete space
    public void deleteEspace(Long id) {
        espaceRepository.deleteById(id);
    }
}
