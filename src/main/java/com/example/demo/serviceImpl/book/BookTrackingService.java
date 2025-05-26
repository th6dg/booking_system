package com.example.demo.serviceImpl.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Iservice.book.IBookTracking;
import com.example.demo.entity.book.BookTracking;
import com.example.demo.entity.user.Member;
import com.example.demo.repository.book.BookTrackingRepo;


@Service
public class BookTrackingService implements IBookTracking{

    @Autowired
    private BookTrackingRepo bookTrackingRepo;

    @Override
    public List<BookTracking> getAllRecord() {
        return bookTrackingRepo.findAll();

    }

    @Override 
    public Member MostFrequentUser(List<BookTracking> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }

        Map<Member, Integer> frequencyMap = new HashMap<>();

        for (BookTracking re : records) {
            if (re != null) {
                frequencyMap.put(re.getMember(), frequencyMap.getOrDefault(re.getMember(), 0) + 1);
            }
        }

        int maxFreq = -1;
        Member mostFrequent = null;

        for (Map.Entry<Member, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;

    }
    
}
