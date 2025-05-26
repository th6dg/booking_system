package com.example.demo.entity.user;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "member", schema = "Library")
@Data   // No-arg constructor
public class Member {

    // 1. @Id - primary
    // 2. No-arg constructor
//    public Hotel() {
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private int Member_id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id", referencedColumnName = "Address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Account_id", referencedColumnName = "account_id")
    private Login login;


    
    

}


