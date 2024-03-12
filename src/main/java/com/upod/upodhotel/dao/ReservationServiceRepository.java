package com.upod.upodhotel.dao;

import com.upod.upodhotel.entities.ReservationService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationServiceRepository extends JpaRepository<ReservationService, Long> {

    void deleteByReservationIdAndServiceId(Long reservationId, Long serviceId);

    List<ReservationService> findAllByReservationId(Long reservationId);

    ReservationService findByReservationIdAndServiceId(Long reservationId, Long serviceId);
}
