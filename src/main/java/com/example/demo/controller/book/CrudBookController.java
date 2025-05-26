package com.example.demo.controller.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Iservice.book.ICrudBook;
import com.example.demo.entity.book.Book;

@Controller
@RequestMapping("/api/book")
public class CrudBookController {
    @Autowired
    private final ICrudBook crudBook;

    public CrudBookController(ICrudBook crudBook) {
        this.crudBook = crudBook;
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        crudBook.create(book);
        return ResponseEntity.ok("Book created successfully");
    }

    @GetMapping
    public ResponseEntity<String> getAllBooks() {
        crudBook.getAll();
        return ResponseEntity.ok("All books retrieved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getBookById(@PathVariable Integer id) {
        Optional<Book> book = crudBook.getById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok("Book found: " + book.get().getName());
        } else {
            return ResponseEntity.status(404).body("Book not found");
        }
    }

    @PutMapping
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        crudBook.update(book);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        if (crudBook.getById(id).isPresent()) {
            crudBook.delete(id);
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Book not found");
        }
    }
}
