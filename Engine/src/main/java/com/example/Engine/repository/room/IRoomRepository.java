package com.example.Engine.repository.room;

import com.example.Engine.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT r.roomId, r.roomType, r.roomStatus, r.price, h.hotelId " +
                    "FROM room r " +
                    "INNER JOIN room_hotel rh ON r.roomId = rh.roomId "+
                    "INNER JOIN hotel h ON rh.roomId = h.hotelId "+
                    "WHERE h.hotelId = :hotelId",  nativeQuery = true)
    List<Room> findRoomByHotel(@Param("hotelId") Long hotelId);

    @Query(value = "SELECT r.roomId FROM room r " +
                    "WHERE r.roomId NOT IN " +
                    "( SELECT b.roomId " +
                    "FROM booking b " +
                    "INNER JOIN dateRange dR ON dR.dateId = b.dateId " +
                    "WHERE dR.fromDate <= :checkOut " +
                    "AND dR.toDate >= :checkIn )", nativeQuery = true)
    List<Long> findRoomNotBookInDateRange(@Param("checkIn") LocalDate checkIn,
                                          @Param("checkOut") LocalDate checkOut);

    @Query(value = "SELECT r.roomType, r.roomStatus, r.price, h.hotelName,"+
                    "l.country, l.province, l.city "+
                    "FROM room as r "+
                    "JOIN room_hotel rh ON r.roomId = rh.roomId "+
                    "JOIN hotel h ON rh.hotelId = h.hotelId "+
                    "JOIN location l ON h.locationId = l.locationId", nativeQuery = true)
    List<Room> getAllRoomAndHotelLocation();
}
