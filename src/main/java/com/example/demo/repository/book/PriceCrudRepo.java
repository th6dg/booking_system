package com.example.demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.book.Price;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface PriceCrudRepo extends JpaRepository<Price, Integer>{
    Price findByPriceId(int priceId);

    
} 