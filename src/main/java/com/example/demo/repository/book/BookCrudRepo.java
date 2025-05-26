package com.example.demo.repository.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.book.Book;

@Repository
public interface BookCrudRepo extends JpaRepository<Book, Integer> {
    List<Book> findByNameContaining(String name);
}
