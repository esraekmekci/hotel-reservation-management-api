package com.upod.upodhotel.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "features")
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    Long id;

    String name;
}
