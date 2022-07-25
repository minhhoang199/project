package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    @Column(length = 100, nullable = false)
    private String image;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double discount;
    @Column(nullable = false)
    private short status;
    @Column(nullable = false)
    private int categoryID;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private int userCreate;
    @Column
    private Date updateDate;
    @Column
    private int userUpdate;
}
