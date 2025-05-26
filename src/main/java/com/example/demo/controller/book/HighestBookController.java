package com.example.demo.controller.book;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.Iservice.book.IHighestBook;
import com.example.demo.entity.book.Book;
import com.example.demo.entity.book.Price;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HighestBookController {
    @Autowired
    private IHighestBook iHighestBook;

    @GetMapping("/api/book/highestPrice")
    public List<Book> getHighestBook() {
        List<Price> prices = iHighestBook.getAllPrice();
        List<Book> allBooks = iHighestBook.getAllBooks();
        HashMap<Integer, Float> map = iHighestBook.findTop3MaxPrince(prices);
        List<Book> resultBooks = iHighestBook.mappingIdToBook(allBooks, map);   
        return resultBooks;
    }
    
}
