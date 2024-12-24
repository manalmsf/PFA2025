package com.example.calendar.repositories;

import com.example.calendar.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
