package com.upod.upodhotel.dao;

import com.upod.upodhotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
    @Query("SELECT r FROM Room r JOIN r.features f WHERE f.id = :featureId")
    List<Room> findAllByFeatureId(Long featureId);

    Room findByRoomNumber(int roomNumber);
}
