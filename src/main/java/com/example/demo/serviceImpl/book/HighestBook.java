package com.example.demo.serviceImpl.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Iservice.book.IHighestBook;
import com.example.demo.entity.book.Book;
import com.example.demo.entity.book.Price;
import com.example.demo.repository.book.BookCrudRepo;
import com.example.demo.repository.book.PriceCrudRepo;

@Service
public class HighestBook implements IHighestBook{
    @Autowired
    private PriceCrudRepo priceCrudRepo;

    @Autowired
    private BookCrudRepo bookCrudRepo;

    @Override
    public List<Price> getAllPrice() {
        return priceCrudRepo.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookCrudRepo.findAll();
    }

    @Override
    public HashMap<Integer, Float> findTop3MaxPrince(List<Price> prices) {
        HashMap<Integer, Float> resultHashMap = new HashMap<>();
        float maxHighest = 0;
        int HighestBookId = 0;
        float maxHighSecond = 0;
        int HighSecondBookId = 0;
        float maxHighThird = 0;
        int HighThirdBookId = 0;
        for (int i = 0; i < prices.size(); i++) {
            Price price = prices.get(i);
            if (price.getPrice() > maxHighest) {
                maxHighThird = maxHighSecond;
                HighThirdBookId = HighSecondBookId;
                maxHighSecond = maxHighest;
                HighSecondBookId = HighestBookId;
                maxHighest = price.getPrice();
                HighestBookId = i;
            }

            if (price.getPrice() > maxHighSecond && price.getPrice() < maxHighest) {
                maxHighThird = maxHighSecond;
                HighThirdBookId = HighSecondBookId;
                maxHighSecond = price.getPrice();
                HighSecondBookId = i;
            }

            if (price.getPrice() > maxHighThird && price.getPrice() < maxHighSecond) {
                maxHighThird = price.getPrice();
                HighThirdBookId = i;
            }
        }

        resultHashMap.put(HighestBookId, maxHighest);
        resultHashMap.put(HighSecondBookId, maxHighSecond);
        resultHashMap.put(HighThirdBookId, maxHighThird);

        return resultHashMap;
    }

    

    @Override
    public List<Book> mappingIdToBook(List<Book> books, HashMap<Integer, Float> priceMap) {
        Map<Integer, Book> bookMap= books.stream()
                    .collect(Collectors.toMap(
                        Book::getBook_id,   // Key: book ID
                        book -> book   // Value: the Book object itself
                    ));
        List<Book> matchedBooks = new ArrayList<>();
        for (Integer bookId : priceMap.keySet()) {
            Book book = bookMap.get(bookId);
            if (book != null) {
                System.out.println("Found book: " + book.getName());
                matchedBooks.add(book);
            } else {
                System.out.println("No book found for ID: " + bookId);
            }
        }
        return matchedBooks;
    }
}
