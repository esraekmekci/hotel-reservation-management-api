package com.upod.upodhotel.controllers;

import com.upod.upodhotel.dto.requests.RoomCreateRequest;
import com.upod.upodhotel.entities.Room;
import com.upod.upodhotel.entities.RoomType;
import com.upod.upodhotel.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms(@RequestParam Optional<Long> featureId) {
        return roomService.getAllRooms(featureId);
    }

    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomById(roomId);
    }

    @GetMapping("/roomtypes")
    public List<RoomType> getRoomTypes() {
        return roomService.getRoomTypes();
    }

    @PostMapping
    public Room saveRoom(@RequestBody RoomCreateRequest newRequest) {
        return roomService.saveRoom(newRequest);
    }

    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable Long roomId, @RequestBody RoomCreateRequest updatedRoom) {
        return roomService.updateRoom(roomId, updatedRoom);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }
}
