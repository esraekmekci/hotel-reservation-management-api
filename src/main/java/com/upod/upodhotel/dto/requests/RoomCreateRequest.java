package com.upod.upodhotel.dto.requests;

import lombok.Data;

@Data
public class RoomCreateRequest {
    private String roomType;
    private int roomNumber;
    private int capacity;
    private double price;
    private Long[] featureIds;
}
