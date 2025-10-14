package com.example.Engine.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckRoomAvalabilityDTO {
    private Long hotelId;
    private Date checkIn;
    private Date checkOut;
}
