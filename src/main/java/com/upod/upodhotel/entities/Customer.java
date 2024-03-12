package com.upod.upodhotel.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Long id;

    @Column(name = "identity_number", unique = true)
    Long identityNumber;

    String name;

    String surname;

    String phone;

    @Column(name = "birth_date")
    Date birthdate;
}
