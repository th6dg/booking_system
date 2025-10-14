package com.example.Engine.service.room;

import com.example.Engine.model.*;

import java.time.LocalDate;
import java.util.List;

/**
 *  @Logic: Check room availabilyty
 */
public interface IRoomAvailability {
    List<Room> getAllRoomInHotel(Long hotelId);

    List<Long> getAllRoomNotBookedInRange(LocalDate checkIn, LocalDate checkOut);

    List<Room> getFinalRoom(Long hotelId, LocalDate checkIn, LocalDate checkOut);
}
