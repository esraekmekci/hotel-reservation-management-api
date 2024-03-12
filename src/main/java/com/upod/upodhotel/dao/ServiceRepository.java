package com.upod.upodhotel.dao;


import com.upod.upodhotel.entities.ReservationService;
import com.upod.upodhotel.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT s FROM Reservation r JOIN r.services s WHERE r.id = :reservationId")
    List<Service> findAllByReservationId(Long reservationId);
}
