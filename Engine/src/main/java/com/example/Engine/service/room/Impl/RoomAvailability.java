package com.example.Engine.service.room.Impl;

import com.example.Engine.entity.Room;
import com.example.Engine.repository.room.IRoomRepository;
import com.example.Engine.service.room.IRoomAvailability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor
@Service
public class RoomAvailability implements IRoomAvailability {
    private final IRoomRepository iRoomRepository;
    @Override
    public List<Room> getAllRoomInHotel(Long hotelId) {
        return iRoomRepository.findRoomByHotel(hotelId);
    }

    @Override
    public List<Long> getAllRoomNotBookedInRange(LocalDate checkIn, LocalDate checkOut) {
        return iRoomRepository.findRoomNotBookInDateRange(checkIn, checkOut);
    }

    @Override
    public List<Room> getFinalRoom(Long hotelId, LocalDate checkIn, LocalDate checkOut) {
        List<Room> allRoom = getAllRoomInHotel(hotelId);
        Set<Long> NotBookedRoomId = getMapFromListRoom(getAllRoomNotBookedInRange(checkIn, checkOut));
        List<Room> finalRoom = new ArrayList<>();
        for (Room room : allRoom) {
            Long roomId = room.getRoomId();
            if (NotBookedRoomId.contains(roomId)) {
                finalRoom.add(room);
            }
        }
        return finalRoom;
    }

    private Set<Long> getMapFromListRoom(List<Long> ListRoomId) {
        return new HashSet<>(ListRoomId);
    }
}
