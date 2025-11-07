package com.example.Engine.service.booking.Impl;

import com.example.Engine.model.BookingRange;

import java.util.Comparator;

public class BookingRangeComparable implements Comparator<BookingRange> {

    @Override
    public int compare(BookingRange o1, BookingRange o2) {
        int roomIdComparison = o1.getRoomId().compareTo(o2.getRoomId());
        if (roomIdComparison != 0) {
            return roomIdComparison;
        }

        int fromDateComparision = o1.getFromDate().compareTo(o2.getFromDate());
        if(fromDateComparision !=0) {
            return fromDateComparision;
        }

        int toDateComparision = o1.getToDate().compareTo(o2.getToDate());
        return toDateComparision;
    }
}
