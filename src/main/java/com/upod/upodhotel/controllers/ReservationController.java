package com.upod.upodhotel.controllers;

import com.upod.upodhotel.dto.requests.ReservationCreateRequest;
import com.upod.upodhotel.entities.Reservation;
import com.upod.upodhotel.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam Optional<Long> customerId,
                                                @RequestParam Optional<Long> roomId) {
        return reservationService.getAllReservations(customerId, roomId);
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody ReservationCreateRequest newReservation) {
        return reservationService.saveReservation(newReservation);
    }

    @PutMapping("/{reservationId}")
    public Reservation updateReservation(@PathVariable Long reservationId, @RequestBody ReservationCreateRequest updatedReservation) {
        return reservationService.updateReservation(reservationId, updatedReservation);
    }

    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }
}
