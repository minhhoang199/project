package com.example.demo.model;

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
public class Customer implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date registeredDate;
    private short status;
}
