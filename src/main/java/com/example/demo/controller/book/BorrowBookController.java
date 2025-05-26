package com.example.demo.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Iservice.book.IBorrowBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("api/borrow/book")
public class BorrowBookController {
    
    @Autowired
    private final IBorrowBook iBorrowBook;

    public BorrowBookController(IBorrowBook iBorrowBook) {
        this.iBorrowBook = iBorrowBook;
    }

    @GetMapping("/add-id-queue")
    public void AddRequestToQueue(@RequestParam int id) {
        iBorrowBook.AddRequest(id);
    }

    @GetMapping("/process-id")
    public void ProcessQueue(@RequestParam int id) {
        iBorrowBook.ProcessRequest(id);;
    }

    @GetMapping("/pop-id")
    public void PopRequest(@RequestParam int id) {
        iBorrowBook.PopRequest(id);;
    }


    






}
