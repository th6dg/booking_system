package com.example.demo.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.Iservice.book.IBookTracking;
import com.example.demo.entity.book.BookTracking;
import com.example.demo.entity.user.Member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookTrackingController {
    
    @Autowired
    private IBookTracking iBookTracking;

    @GetMapping("/all-record")
    public List<BookTracking> getAllRecord() {
        return iBookTracking.getAllRecord();
    }

    @GetMapping("most-borrow-member")
    public Member MostFrequentUser(@RequestParam String param) {
        return iBookTracking.MostFrequentUser(iBookTracking.getAllRecord());
    }
    
    
}
