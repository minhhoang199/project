package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int customerID;
    @Column(nullable = false)
    private int productID;
    @Column(nullable = false)
    private double quantity;
    @Column(nullable = false)
    private double totalPrice;
    @Column(nullable = false)
    private short status;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
}
