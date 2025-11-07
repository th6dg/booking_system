package com.example.Engine.service.room.Impl;

import com.example.Engine.dto.entity.RoomFilterDTO;
import com.example.Engine.entity.Room;
import com.example.Engine.repository.room.IRoomRepository;
import com.example.Engine.service.room.IRoomFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


// UC: Filter room using Functional Programming
@Service
@AllArgsConstructor
public class RoomFilter implements IRoomFilter {
    private final IRoomRepository iRoomRepository;

    public List<RoomFilterDTO> getAllRoom(){
        return iRoomRepository.getAllRoomAndHotelLocation();
    }


    @Override
    public List<RoomFilterDTO> filterRoom(List<RoomFilterDTO> rooms, Predicate<RoomFilterDTO> p) {
        List<RoomFilterDTO> result = new ArrayList<>();
        for (RoomFilterDTO r:rooms) {
            if (p.test(r)) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public List<Object> retrieveValueFromRoom(List<RoomFilterDTO> rooms, Function<RoomFilterDTO, Object> f) {
        List<Object> result = new ArrayList<>();
        for (RoomFilterDTO r:rooms) {
            result.add(f.apply(r));
        }
        return result;
    }

    @Override
    public RoomFilterDTO createRandomRandom(Supplier<RoomFilterDTO> s) {
        return s.get();
    }

    @Override
    public void logInfoRoom(RoomFilterDTO room, Consumer<RoomFilterDTO> c) {
        c.accept(room);

    }


}
