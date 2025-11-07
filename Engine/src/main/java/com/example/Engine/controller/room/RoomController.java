package com.example.Engine.controller.room;

import com.example.Engine.dto.request.CheckRoomAvalabilityDTO;
import com.example.Engine.dto.response.RoomResponseDTO;
import com.example.Engine.entity.Room;
import com.example.Engine.service.room.Impl.RoomAvailability;
import com.example.Engine.service.room.Impl.RoomFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomAvailability roomAvailability;
    private final RoomFilter roomFilter;
    /**
     *  Api 1: Get available room in specific hotel
     */
    @GetMapping("/hotel")
    public List<RoomResponseDTO> getRoomInHotel(@Valid @RequestParam Long hotelId) {
        return roomAvailability.getAllRoomInHotel(hotelId)
                .stream()
                .map(r -> new RoomResponseDTO(
                        r.getRoomId(),
                        r.getRoomType(),
                        r.getRoomStatus(),
                        r.getPrice(),
                        r.getHotel().getHotelName()
                ))
                .toList();
    }

    /**
     *  Api 2: Get room cheapest < threshold
     */

    /**
     *  Api 3: Check available room in date range
     */
    @PostMapping("/checkAvailability")
    public List<RoomResponseDTO> getAvailabilityRoom(@Valid @RequestBody CheckRoomAvalabilityDTO checkRoomAvalabilityDTO) {
        return roomAvailability.getFinalRoom(checkRoomAvalabilityDTO.getHotelId(), checkRoomAvalabilityDTO.getCheckIn(), checkRoomAvalabilityDTO.getCheckOut())
                .stream()
                .map(r -> new RoomResponseDTO(
                        r.getRoomId(),
                        r.getRoomType(),
                        r.getRoomStatus(),
                        r.getPrice(),
                        r.getHotel().getHotelName()
                ))
                .toList();
    }

    @GetMapping("/roomFilter")
    public List<Room> getFilterBasedRoom() {
        return roomFilter.getAllRoom();
    }
}
