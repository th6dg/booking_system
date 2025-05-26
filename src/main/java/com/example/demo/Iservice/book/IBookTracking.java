package com.example.demo.Iservice.book;

import java.util.List;

import com.example.demo.entity.book.BookTracking;
import com.example.demo.entity.user.Member;

public interface IBookTracking {
    List<BookTracking> getAllRecord();

    Member MostFrequentUser(List<BookTracking> records);
    
} 
