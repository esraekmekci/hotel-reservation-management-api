package com.upod.upodhotel.services;

import com.upod.upodhotel.entities.ReservationService;

import java.util.List;

public interface RSService {

    List<ReservationService> getAllServicesByReservationId(Long reservationId);
    void deleteRSService(Long reservationId, Long serviceId);


}
