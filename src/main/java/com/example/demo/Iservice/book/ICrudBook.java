package com.example.demo.Iservice.book;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.book.Book;

public interface ICrudBook {

    // Create new book
    Book create(Book book);

    // Get all books     
    List<Book> getAll();

    
    //Get book by ID
    Optional<Book> getById(Integer id);
    
    // Update an existing book
    Book update(Book book);

    
    //Delete a book by ID
    void delete(Integer id);
    
}