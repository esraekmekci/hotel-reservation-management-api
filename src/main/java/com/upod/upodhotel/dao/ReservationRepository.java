package com.upod.upodhotel.dao;

import com.upod.upodhotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoomId(Long roomId);

    @Query("SELECT r FROM Reservation r JOIN r.customers c WHERE (:customerId is null or c.id = :customerId) AND (:roomId is null or r.room.id = :roomId)")
    List<Reservation> findByCustomerIdAndRoomId(Long customerId, Long roomId);

    @Query("SELECT r FROM Reservation r JOIN r.customers c JOIN r.services WHERE (:customerId is null or c.id = :customerId) AND (:roomId is null or r.room.id = :roomId)")
    List<Reservation> findByCustomerIdAndRoomIdWithServices(Long customerId, Long roomId);

}
