package com.example.Engine.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckRoomAvalabilityDTO implements Serializable {
    @NotNull(message = "hotel id must be not null")
    private Long hotelId;
    @NotNull
    private LocalDate checkIn;
    private LocalDate checkOut;
}
