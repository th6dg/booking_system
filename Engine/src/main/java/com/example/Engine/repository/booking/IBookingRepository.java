package com.example.Engine.repository.booking;

import com.example.Engine.entity.Booking;
import com.example.Engine.model.BookingRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

    @Query(value = "SELECT b.roomId as roomId, d.fromDate AS fromDate, d.toDate AS toDate " +
                    "FROM booking b "+
                    "INNER JOIN dateRange d ON b.dateId = d.dateId "+
                    "WHERE d.fromDate < :to AND d.toDate > :from", nativeQuery = true)
    List<BookingRange> getBookingInRange(@Param("from") LocalDate from,
                                         @Param("to") LocalDate to);

}
