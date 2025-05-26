package com.example.demo.entity.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "price_book", schema = "Library")
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PriceId")
    private int PriceId;

    @Column(name = "price", nullable = false)
    private float price;

    @OneToOne
    @JoinColumn(name = "bookId", referencedColumnName = "book_id", unique = true)
    private Book book;

}
