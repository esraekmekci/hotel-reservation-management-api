package com.upod.upodhotel.services.impl;

import com.upod.upodhotel.dao.ReservationRepository;
import com.upod.upodhotel.dao.ReservationServiceRepository;
import com.upod.upodhotel.dao.RoomRepository;
import com.upod.upodhotel.dto.requests.ReservationCreateRequest;
import com.upod.upodhotel.entities.Customer;
import com.upod.upodhotel.entities.Reservation;
import com.upod.upodhotel.entities.Room;
import com.upod.upodhotel.services.CustomerService;
import com.upod.upodhotel.services.ReservationService;
import com.upod.upodhotel.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerService customerService;
    private final RoomRepository roomRepository;
    private final com.upod.upodhotel.services.ServiceService serviceService;
    private final ReservationServiceRepository reservationServiceRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, CustomerService customerService, com.upod.upodhotel.services.ServiceService serviceService, RoomRepository roomRepository, ReservationServiceRepository reservationServiceRepository) {
        this.reservationRepository = reservationRepository;
        this.customerService = customerService;
        this.serviceService = serviceService;
        this.roomRepository = roomRepository;
        this.reservationServiceRepository = reservationServiceRepository;
    }

    @Override
    public List<Reservation> getAllReservations(Optional<Long> customerId, Optional<Long> roomId) {
        Long customerIdLong = customerId.orElse(null);
        Long roomIdLong = roomId.orElse(null);
        if (customerIdLong != null || roomIdLong != null) {
            return reservationRepository.findByCustomerIdAndRoomId(customerIdLong, roomIdLong);
        } else {
            return reservationRepository.findAll();
        }
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    @Override
    public Reservation saveReservation(ReservationCreateRequest newReservation) {
        List<Customer> customers = new ArrayList<>();
        for (Long customerId : newReservation.getCustomerIds()) {
            Customer customer = customerService.getCustomerById(customerId);
            if (customer != null)
                customers.add(customer);
        }

        Room room = roomRepository.findByRoomNumber(Math.toIntExact(newReservation.getRoomNumber()));

        List<com.upod.upodhotel.entities.Service> services = new ArrayList<>();
        for (Long serviceId : newReservation.getServiceIds()) {
            com.upod.upodhotel.entities.Service service = serviceService.getServiceById(serviceId);
            if (service != null)
                services.add(service);
        }

        Reservation reservation = new Reservation();
        reservation.setCheckInDate(newReservation.getCheckInDate());
        reservation.setCheckOutDate(newReservation.getCheckOutDate());
        reservation.setCheckedInDate(newReservation.getCheckedInDate());
        reservation.setCheckedOutDate(newReservation.getCheckedOutDate());
        reservation.setCustomers(customers);
        reservation.setServices(services);
        reservation.setRoom(room);
        reservationRepository.save(reservation);

        for (int i = 0; i < newReservation.getServiceQuantities().length; i++) {
            com.upod.upodhotel.entities.ReservationService rs = reservationServiceRepository.findByReservationIdAndServiceId(reservation.getId(), services.get(i).getId());
            rs.setQuantity(newReservation.getServiceQuantities()[i]);
            reservationServiceRepository.save(rs);
        }

        return reservation;
    }

    @Override
    public Reservation updateReservation(Long reservationId, ReservationCreateRequest updatedReservation) {
        List<Customer> customers = new ArrayList<>();
        for (Long customerId : updatedReservation.getCustomerIds()) {
            Customer customer = customerService.getCustomerById(customerId);
            if (customer != null)
                customers.add(customer);
        }

        Room room = roomRepository.findByRoomNumber(updatedReservation.getRoomNumber());

        List<com.upod.upodhotel.entities.Service> services = new ArrayList<>();
        for (Long serviceId : updatedReservation.getServiceIds()) {
            com.upod.upodhotel.entities.Service service = serviceService.getServiceById(serviceId);
            if (service != null)
                services.add(service);
        }

        Optional<Reservation> reservation = reservationRepository.findById(reservationId);

        if (reservation.isPresent()) {
            Reservation foundReservation = reservation.get();
            foundReservation.setCheckInDate(updatedReservation.getCheckInDate());
            foundReservation.setCheckOutDate(updatedReservation.getCheckOutDate());
            foundReservation.setCheckedInDate(updatedReservation.getCheckedInDate());
            foundReservation.setCheckedOutDate(updatedReservation.getCheckedOutDate());
            foundReservation.setCustomers(customers);
            foundReservation.setRoom(room);
            foundReservation.setServices(services);
            reservationRepository.save(foundReservation);
            for (int i = 0; i < updatedReservation.getServiceQuantities().length; i++) {
                com.upod.upodhotel.entities.ReservationService rs = reservationServiceRepository.findByReservationIdAndServiceId(foundReservation.getId(), services.get(i).getId());
                rs.setQuantity(updatedReservation.getServiceQuantities()[i]);
                reservationServiceRepository.save(rs);
            }
            return foundReservation;
        } else {
            return null;
        }
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
