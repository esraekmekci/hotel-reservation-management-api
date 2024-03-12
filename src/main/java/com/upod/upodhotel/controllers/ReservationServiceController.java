package com.upod.upodhotel.controllers;

import com.upod.upodhotel.services.RSService;
import com.upod.upodhotel.entities.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservationservices")
public class ReservationServiceController {
    private final RSService rsService;

    public ReservationServiceController(RSService rsService) {
        this.rsService = rsService;
    }

    @GetMapping("/{reservationId}")
    public List<ReservationService> getAllServicesByReservationId(@PathVariable Long reservationId) {
        return rsService.getAllServicesByReservationId(reservationId);
    }

}
