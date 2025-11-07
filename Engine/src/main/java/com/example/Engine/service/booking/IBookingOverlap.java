package com.example.Engine.service.booking;

import com.example.Engine.entity.Booking;
import com.example.Engine.model.BookingRange;

import java.time.LocalDate;
import java.util.List;

/**
 * @Context/Issue: Check booking has been overlapped or not
 * @Input: List<Booking> in range
 * @Output: List Object get overlap, null if all not overlap
 * @DataStructure: TreeSet + Comparator
 */
public interface IBookingOverlap {
    List<BookingRange> getBookingInRange(LocalDate from, LocalDate to);

    List<BookingRange> checkOverlap(List<BookingRange> bookingInput, List<BookingRange> allBooking);
}
