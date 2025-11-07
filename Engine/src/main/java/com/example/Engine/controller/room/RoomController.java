package com.example.Engine.controller.room;

import com.example.Engine.dto.entity.RoomFilterDTO;
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
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

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

    private String generateRandomUUIDString() {
        // Tạo một chuỗi ID ngẫu nhiên, ví dụ: "a1b2c3d4-e5f6-7890-abcd-ef0123456789"
        String randomString = UUID.randomUUID().toString();
        return randomString;
    }
    public static long generateRandomLongInRange(long min, long max) {
        // nextLong(origin, bound) trả về giá trị từ origin (bao gồm) đến bound (không bao gồm)
        long randomLongInRange = ThreadLocalRandom.current().nextLong(min, max + 1);
        return randomLongInRange;
    }

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

    @GetMapping(value = "/roomFilter", params = "country")
    public List<RoomFilterDTO> getFilterBasedRoomByCountry(@RequestParam(required = false) String country) {
       List<RoomFilterDTO> allRoom = roomFilter.getAllRoom();
        List<RoomFilterDTO> output = roomFilter.filterRoom(allRoom, (RoomFilterDTO r) -> {return r.getCountry().equals(country);});
        return output;
    }

    @GetMapping(value = "/roomFilter", params = "price")
    public List<RoomFilterDTO> getFilterBasedRoomByPrice(@RequestParam(required = false) Long price) {
        List<RoomFilterDTO> allRoom = roomFilter.getAllRoom();
        List<RoomFilterDTO> output = roomFilter.filterRoom(allRoom, (r) -> r.getPrice() > price);
        return output;
    }

    @GetMapping(value = "/getPrice")
    public List<Object> getPriceFromRoom() {
        List<RoomFilterDTO> allRoom = roomFilter.getAllRoom();
        List<Object> output = roomFilter.retrieveValueFromRoom(allRoom, (r) -> {
            // Some logic
            if (r.getPrice() > 200) {
                return  Optional.of(r.getPrice());
            }
            return Optional.empty();
        });
        return output;
    }

    @PostMapping(value = "/createRoom")
    public RoomFilterDTO createRoom() {
        return roomFilter.createRandomRandom(() -> {

            RoomFilterDTO room = new RoomFilterDTO() {
            @Override
            public Long getRoomId() {
                return generateRandomLongInRange(200,300);
            }

            @Override
            public String getRoomType() {
                return "SINGLE";
            }

            @Override
            public String getRoomStatus() {
                return "AVAILABLE";
            }

            @Override
            public Long getPrice() {
                return generateRandomLongInRange(100,500);
            }

            @Override
            public Long getHotelId() {
                return generateRandomLongInRange(200,500);
            }

            @Override
            public String getHotelName() {
                return generateRandomUUIDString();
            }

            @Override
            public Long getLocationId() {
                return generateRandomLongInRange(100,200);
            }

            @Override
            public String getCountry() {
                return generateRandomUUIDString();
            }

            @Override
            public String getProvince() {
                return generateRandomUUIDString();
            }

            @Override
            public String getCity() {
                return generateRandomUUIDString();
            }

            @Override
            public String toString() {
                return "Create Success at hotel: " + this.getHotelName();
            }
            };
            roomFilter.logInfoRoom(room, (r) -> System.out.println(r));
            return room;
        });
    }



}
