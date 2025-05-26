package com.example.demo.repository.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.book.BookTracking;

@Repository
public interface BookTrackingRepo extends JpaRepository<BookTracking, Integer>{
    List<BookTracking> findByDateCheckIn(LocalDate dateCheckIn);
    List<BookTracking> findByDateCheckOut(LocalDate dateCheckOut);
}