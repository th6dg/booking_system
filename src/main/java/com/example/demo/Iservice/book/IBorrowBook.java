package com.example.demo.Iservice.book;

public interface IBorrowBook {

    void AddRequest(int request);

    void PopRequest(int request);

    void ProcessRequest(int request);
}
