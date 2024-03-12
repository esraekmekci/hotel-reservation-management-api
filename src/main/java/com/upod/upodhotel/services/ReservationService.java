package com.upod.upodhotel.services;

import com.upod.upodhotel.dto.requests.ReservationCreateRequest;
import com.upod.upodhotel.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservations(Optional<Long> customerId, Optional<Long> roomId);

    Reservation getReservationById(Long reservationId);

    Reservation saveReservation(ReservationCreateRequest newReservation);

    Reservation updateReservation(Long reservationId, ReservationCreateRequest updatedReservation);

    void deleteReservation(Long reservationId);
}
