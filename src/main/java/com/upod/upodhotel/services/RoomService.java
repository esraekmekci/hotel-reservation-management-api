package com.upod.upodhotel.services;

import com.upod.upodhotel.dto.requests.RoomCreateRequest;
import com.upod.upodhotel.entities.Room;
import com.upod.upodhotel.entities.RoomType;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAllRooms(Optional<Long> featureId);

    Room getRoomById(Long roomId);

    List<RoomType> getRoomTypes();

    Room saveRoom(RoomCreateRequest newRoom);

    Room updateRoom(Long roomId, RoomCreateRequest updatedRoom);

    void deleteRoom(Long roomId);
}
