package com.example.Engine.controller.room;

import com.example.Engine.model.Room;
import com.example.Engine.service.room.Impl.RoomAvailability;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomAvailability roomAvailability;
    /**
     *  Api 1: Get available room in specific hotel
     */
    @GetMapping("/hotel")
    public List<Room> getRoomInHotel(@RequestParam Long hotelId) {
        return roomAvailability.getAllRoomInHotel(hotelId);
    }

    /**
     *  Api 2: Crud Room
     */

    /**
     *  Api 3: Check available room in date range
     */
    @GetMapping("/checkAvailability")
    public List<Room> getAvailabilityRoom(@RequestParam Long hotelId,
                                          @RequestParam LocalDate checkIn,
                                          @RequestParam LocalDate checkOut) {
        return roomAvailability.getFinalRoom(hotelId, checkIn, checkOut);
    }
}
