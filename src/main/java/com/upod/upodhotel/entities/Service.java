package com.upod.upodhotel.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "services")
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    Long id;

    String name;

    @Column(name = "unit_price")
    double unitPrice;
}
