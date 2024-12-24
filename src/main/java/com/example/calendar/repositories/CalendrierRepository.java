package com.example.calendar.repositories;

import com.example.calendar.models.Calendrier;
import org.springframework.data.repository.CrudRepository;

public interface CalendrierRepository extends CrudRepository<Calendrier, Long> {
}
