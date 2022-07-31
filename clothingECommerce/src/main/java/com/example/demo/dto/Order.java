package com.example.demo.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order implements Serializable {
    private int id;
    private int customerID;
    private int productID;
    private double quantity;
    private double totalPrice;
    private short status;
    private Date orderDate;
}
