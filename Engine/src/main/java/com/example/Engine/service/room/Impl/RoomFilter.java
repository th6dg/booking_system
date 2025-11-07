package com.example.Engine.service.room.Impl;

import com.example.Engine.entity.Room;
import com.example.Engine.repository.room.IRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


// UC: Filter room using Functional Programming
@Service
@AllArgsConstructor
public class RoomFilter {
    private final IRoomRepository iRoomRepository;

    public List<Room> getAllRoom(){
        return iRoomRepository.getAllRoomAndHotelLocation();
    }


}
