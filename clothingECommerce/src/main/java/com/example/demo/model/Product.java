package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String image;
    private String description;
    private double discount;
    private short status;
    private int categoryID;
    private Date createDate;
    private int userCreate;
    private Date updateDate;
    private int userUpdate;
}
