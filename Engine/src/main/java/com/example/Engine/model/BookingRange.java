package com.example.Engine.model;

import com.example.Engine.entity.Booking;

import java.time.LocalDate;

/*
    Interface Projection:
    + You're using SQL aliases (m.first_name AS firstName,...)  in SELECT clause.

    + Spring Data JPA automatically maps the column names from SQL result set (using the aliases)
    to the corresponding getter method names in the MeInfo interface.

    + Specifically, it maps a column named firstName to the method getFirstName().
*/
public interface BookingRange {
    Long getRoomId();
    LocalDate getFromDate();
    LocalDate getToDate();
}
