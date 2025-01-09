package com.example.calendar.controllers;

import com.example.calendar.models.Calendrier;
import com.example.calendar.services.CalendrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendriers") // routes
public class CalendrierController {

    private final CalendrierService calendrierService;

    @Autowired //injection auto des deps
    public CalendrierController(CalendrierService calendrierService) {
        this.calendrierService = calendrierService;
    }

    @GetMapping
    public List<Calendrier> getAllCalendriers() {
        return calendrierService.getAllCalendriers();
    }


    @PostMapping
    public Calendrier createCalendrier(@RequestBody Calendrier calendrier) {
        return calendrierService.createCalendrier(calendrier);
    }

    @GetMapping("/{id}")
    public Calendrier getCalendrierById(@PathVariable Long id) {
        return calendrierService.getCalendrierById(id);
    }

    @PutMapping("/{id}")
    public Calendrier updateCalendrier(@PathVariable Long id, @RequestBody Calendrier updatedCalendrier) {
        return calendrierService.updateCalendrier(id, updatedCalendrier);
    }


    @DeleteMapping("/{id}")
    public void deleteCalendrier(@PathVariable Long id) {
        calendrierService.deleteCalendrier(id);
    }
}