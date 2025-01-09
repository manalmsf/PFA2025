package com.example.calendar.services;

// Importing the repository interface for database operations.
import com.example.calendar.models.Calendrier;
import com.example.calendar.repositories.CalendrierRepository;

// Importing the annotation to mark this class as a service component in the Spring application context.
import org.springframework.stereotype.Service;

// Importing necessary classes for handling lists and optional values.
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Marking this class as a Spring service to handle the business logic for the Calendrier entity.
@Service
public class CalendrierService {

    // Declaring a reference to the repository for database operations.
    private final CalendrierRepository calendrierRepository;

    // Constructor for dependency injection of the repository.
    public CalendrierService(CalendrierRepository calendrierRepository) {
        this.calendrierRepository = calendrierRepository;
    }

    // Method to retrieve all Calendrier entities from the database.
    public List<Calendrier> getAllCalendriers() {
        // Creating a list to store the retrieved entities.
        List<Calendrier> list = new ArrayList<>();
        // Iterating through all retrieved entities and adding them to the list.
        calendrierRepository.findAll().forEach(list::add);
        // Returning the list of all Calendrier entities.
        return list;
    }

    // Method to create a new Calendrier entity and save it to the database.
    public Calendrier createCalendrier(Calendrier calendrier) {
        // Saving the Calendrier entity and returning the saved instance.
        return calendrierRepository.save(calendrier);
    }

    // Method to retrieve a single Calendrier entity by its ID.
    public Calendrier getCalendrierById(Long id) {
        // Attempting to find the entity by ID, wrapped in an Optional.
        Optional<Calendrier> calendrier = calendrierRepository.findById(id);
        // Returning the entity if found, or throwing a RuntimeException if not found.
        return calendrier.orElseThrow(() -> new RuntimeException("Calendrier not found with id " + id));
    }

    // Method to update an existing Calendrier entity by its ID.
    public Calendrier updateCalendrier(Long id, Calendrier updatedCalendrier) {
        // Retrieving the existing entity by its ID.
        Calendrier existingCalendrier = getCalendrierById(id);
        // Updating the fields of the existing entity with the values from the updated entity.
        existingCalendrier.setDate(updatedCalendrier.getDate());
        existingCalendrier.setHeure(updatedCalendrier.getHeure());
        existingCalendrier.setDescription(updatedCalendrier.getDescription());
        // Saving the updated entity back to the database and returning it.
        return calendrierRepository.save(existingCalendrier);
    }

    // Method to delete a Calendrier entity by its ID.
    public void deleteCalendrier(Long id) {
        // Deleting the entity with the specified ID.
        calendrierRepository.deleteById(id);
    }
}
