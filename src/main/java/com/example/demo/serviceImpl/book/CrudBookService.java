package com.example.demo.serviceImpl.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Iservice.book.ICrudBook;
import com.example.demo.entity.book.Book;
import com.example.demo.repository.book.BookCrudRepo;


@Service
public class CrudBookService implements ICrudBook{

    private final BookCrudRepo bookCrudRepository;

    public CrudBookService(BookCrudRepo bookCrudRepository) {
        this.bookCrudRepository = bookCrudRepository;
    }

    @Override
    public Book create(Book book) {
        return bookCrudRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookCrudRepository.findAll();
    }

    @Override
    public Optional<Book> getById(Integer id) {
        return bookCrudRepository.findById(id);
    }

    @Override
    public Book update(Book book) {
        return bookCrudRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookCrudRepository.deleteById(id);
    }
    
}
