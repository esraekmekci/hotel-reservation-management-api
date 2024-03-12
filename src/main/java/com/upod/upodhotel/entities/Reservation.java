package com.upod.upodhotel.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Room room;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reservation_customer",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Customer> customers;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "reservation_service",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Service> services;

    @Column(name = "check_in_date")
    Date checkInDate;

    @Column(name = "check_out_date")
    Date checkOutDate;

    @Column(name = "checked_in_date")
    Date checkedInDate;

    @Column(name = "checked_out_date")
    Date checkedOutDate;
}
