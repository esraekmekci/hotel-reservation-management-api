package com.upod.upodhotel.dto.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class ReservationCreateRequest {
    Long[] customerIds;
    Long[] serviceIds;
    int[] serviceQuantities;
    int roomNumber;
    Date checkInDate;
    Date checkOutDate;
    Date checkedInDate;
    Date checkedOutDate;
}
