package com.example.calendar.controllers;

import com.example.calendar.models.Espace;
import com.example.calendar.services.EspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espaces")
public class EspaceController {

    private final EspaceService espaceService;

    @Autowired
    public EspaceController(EspaceService espaceService) {
        this.espaceService = espaceService;
    }

    @GetMapping
    public List<Espace> getAllEspaces() {
        return espaceService.getAllEspaces();
    }

    @PostMapping
    public Espace createEspace(@RequestBody Espace espace) {
        return espaceService.createEspace(espace);
    }

    @GetMapping("/{id}")
    public Espace getEspaceById(@PathVariable Long id) {
        return espaceService.getEspaceById(id);
    }

    @PutMapping("/{id}")
    public Espace updateEspace(@PathVariable Long id, @RequestBody Espace updatedEspace) {
        return espaceService.updateEspace(id, updatedEspace);
    }

    @DeleteMapping("/{id}")
    public void deleteEspace(@PathVariable Long id) {
        espaceService.deleteEspace(id);
    }
}