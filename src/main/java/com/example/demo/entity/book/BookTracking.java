package com.example.demo.entity.book;

import java.time.LocalDate;

import com.example.demo.entity.user.Login;
import com.example.demo.entity.user.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_tracking")
@Data
public class BookTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_tracking_id")
    private int Book_TrackingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "user_id")
    @Column(name = "user_id")
    private  Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @Column(name = "book_id")
    private Book book;

    @Column(name ="date_check_in")
    private LocalDate Date_CheckIn;

    @Column(name ="date_check_out")
    private LocalDate Date_CheckOut;
}
