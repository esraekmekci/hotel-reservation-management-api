package com.upod.upodhotel.services.impl;

import com.upod.upodhotel.dao.ServiceRepository;
import com.upod.upodhotel.entities.Customer;
import com.upod.upodhotel.entities.ReservationService;
import com.upod.upodhotel.services.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<com.upod.upodhotel.entities.Service> getAllServices(Optional<Long> reservationId) {
        if (reservationId.isEmpty()) {
            return serviceRepository.findAll();
        }
        return serviceRepository.findAllByReservationId(reservationId.orElse(null));
    }

    @Override
    public com.upod.upodhotel.entities.Service saveService(com.upod.upodhotel.entities.Service newService) {
        return serviceRepository.save(newService);
    }

    @Override
    public com.upod.upodhotel.entities.Service getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId).orElse(null);
    }

    @Override
    public com.upod.upodhotel.entities.Service updateService(Long serviceId, com.upod.upodhotel.entities.Service updatedService) {
        Optional<com.upod.upodhotel.entities.Service> service = serviceRepository.findById(serviceId);
        if (service.isPresent()) {
            com.upod.upodhotel.entities.Service foundService = service.get();
            foundService.setName(updatedService.getName());
            foundService.setUnitPrice(updatedService.getUnitPrice());
            serviceRepository.save(foundService);
            return foundService;
        } else {
            return null;
        }
    }

    @Override
    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
