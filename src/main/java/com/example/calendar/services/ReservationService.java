package com.example.calendar.services;

import com.example.calendar.models.Reservation;
import com.example.calendar.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable avec l'ID : " + id));
    }

    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Réservation introuvable avec l'ID : " + id);
        }
        reservationRepository.deleteById(id);
    }
}