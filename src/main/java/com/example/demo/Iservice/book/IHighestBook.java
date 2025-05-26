package com.example.demo.Iservice.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.entity.book.Book;
import com.example.demo.entity.book.Price;

public interface IHighestBook {
    List<Price> getAllPrice();

    List<Book> getAllBooks();

    HashMap<Integer, Float> findTop3MaxPrince (List<Price> prices);

    List<Book> mappingIdToBook(List<Book> books, HashMap<Integer, Float> hashMap);
}
