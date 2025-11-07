package com.example.Engine.service.booking.Impl;

import com.example.Engine.model.BookingRange;
import com.example.Engine.repository.booking.IBookingRepository;
import com.example.Engine.service.booking.IBookingOverlap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
@AllArgsConstructor
public class BookingOverlap implements IBookingOverlap {

    private final IBookingRepository iBookingRepository;

    @Override
    public List<BookingRange> getBookingInRange(LocalDate from, LocalDate to) {
        return iBookingRepository.getBookingInRange(from,to);
    }

    @Override
    public List<BookingRange> checkOverlap(List<BookingRange> bookingInput, List<BookingRange> allBooking) {
        TreeSet<BookingRange> bookingRanges = new TreeSet<>(new BookingRangeComparable());
        for(BookingRange booking:allBooking) {
            bookingRanges.add(booking);
        }

        List<BookingRange> overlapBooking = new ArrayList<>();

        for (BookingRange inputBooking:allBooking) {
            for (BookingRange booking : bookingRanges) {
                if (booking.getRoomId() == inputBooking.getRoomId()){
                    if (booking.getFromDate().isBefore(inputBooking.getFromDate()) && inputBooking.getFromDate().isBefore(booking.getToDate())) {
                        overlapBooking.add(inputBooking);
                        continue;
                    }
                    if (booking.getFromDate().isBefore(inputBooking.getToDate()) && inputBooking.getToDate().isBefore(booking.getToDate())) {
                        overlapBooking.add(inputBooking);
                    }
                }
            }
        }
        return overlapBooking;
    }
}
