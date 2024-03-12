package com.upod.upodhotel.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "room_feature",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Feature> features;
    @Column(name = "room_number")
    int roomNumber;
    int capacity;
    double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType roomType;

}
