package com.upod.upodhotel.services.impl;

import com.upod.upodhotel.dao.ReservationServiceRepository;
import com.upod.upodhotel.services.RSService;
import com.upod.upodhotel.entities.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RSServiceImpl implements RSService {
    private final ReservationServiceRepository reservationServiceRepository;

    public RSServiceImpl(ReservationServiceRepository reservationServiceRepository) {
        this.reservationServiceRepository = reservationServiceRepository;
    }


    @Override
    public List<ReservationService> getAllServicesByReservationId(Long reservationId) {
        return reservationServiceRepository.findAllByReservationId(reservationId);
    }

    @Override
    public void deleteRSService(Long reservationId, Long serviceId) {
        reservationServiceRepository.deleteByReservationIdAndServiceId(reservationId, serviceId);
    }
}
