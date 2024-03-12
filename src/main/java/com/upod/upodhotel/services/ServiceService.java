package com.upod.upodhotel.services;

import com.upod.upodhotel.entities.ReservationService;
import com.upod.upodhotel.entities.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<Service> getAllServices(Optional<Long> reservationId);

    Service saveService(Service newService);

    Service getServiceById(Long serviceId);

    Service updateService(Long serviceId, Service updatedService);

    void deleteService(Long serviceId);
}
