package com.upod.upodhotel.controllers;

import com.upod.upodhotel.entities.Reservation;
import com.upod.upodhotel.entities.ReservationService;
import com.upod.upodhotel.entities.Service;
import com.upod.upodhotel.services.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getAllServices(@RequestParam Optional<Long> reservationId) {
        return serviceService.getAllServices(reservationId);
    }


    @PostMapping
    public Service createService(@RequestBody Service newService) {
        return serviceService.saveService(newService);
    }

    @GetMapping("/{serviceId}")
    public Service getServiceById(@PathVariable Long serviceId) {
        return serviceService.getServiceById(serviceId);
    }

    @PutMapping("/{serviceId}")
    public Service updateService(@PathVariable Long serviceId, @RequestBody Service updatedService) {
        return serviceService.updateService(serviceId, updatedService);
    }

    @DeleteMapping("/{serviceId}")
    public void deleteService(@PathVariable Long serviceId) {
        serviceService.deleteService(serviceId);
    }

}
