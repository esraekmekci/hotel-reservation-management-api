package com.upod.upodhotel.services.impl;

import com.upod.upodhotel.dao.RoomRepository;
import com.upod.upodhotel.dto.requests.RoomCreateRequest;
import com.upod.upodhotel.entities.Feature;
import com.upod.upodhotel.entities.Room;
import com.upod.upodhotel.entities.RoomType;
import com.upod.upodhotel.services.FeatureService;
import com.upod.upodhotel.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final FeatureService featureService;

    public RoomServiceImpl(RoomRepository roomRepository, FeatureService featureService) {
        this.roomRepository = roomRepository;
        this.featureService = featureService;
    }

    @Override
    public List<Room> getAllRooms(Optional<Long> featureId) {
        if (featureId.isEmpty()) {
            return roomRepository.findAll();
        }
        return roomRepository.findAllByFeatureId(featureId.orElse(null));
    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public List<RoomType> getRoomTypes() {
        return Arrays.asList(RoomType.values());
    }

    @Override
    public Room saveRoom(RoomCreateRequest newRequest) {
        List<Feature> features = new ArrayList<>();
        for (Long featureId : newRequest.getFeatureIds()) {
            Feature feature = featureService.getFeatureById(featureId);
            if (feature != null)
                features.add(feature);
        }
        if (roomRepository.findByRoomNumber(newRequest.getRoomNumber()) == null){
            Room newRoom = new Room();
            newRoom.setRoomNumber(newRequest.getRoomNumber());
            newRoom.setCapacity(newRequest.getCapacity());
            newRoom.setPrice(newRequest.getPrice());
            newRoom.setRoomType(RoomType.valueOf(newRequest.getRoomType()));
            newRoom.setFeatures(features);
            return roomRepository.save(newRoom);
        }
        return null;
    }

    @Override
    public Room updateRoom(Long roomId, RoomCreateRequest updatedRoom) {
        List<Feature> features = new ArrayList<>();
        for (Long featureId : updatedRoom.getFeatureIds()) {
            Feature feature = featureService.getFeatureById(featureId);
            features.add(feature);
        }
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            Room foundRoom = room.get();
            foundRoom.setRoomNumber(updatedRoom.getRoomNumber());
            foundRoom.setCapacity(updatedRoom.getCapacity());
            foundRoom.setPrice(updatedRoom.getPrice());
            foundRoom.setRoomType(RoomType.valueOf(updatedRoom.getRoomType()));
            foundRoom.setFeatures(features);
            roomRepository.save(foundRoom);
            return foundRoom;
        } else {
            return null;
        }
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
