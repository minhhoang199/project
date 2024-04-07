package com.example.cloudconfigserver;

import lombok.Data;

import java.util.List;

@Data
public class ObjectTest {
    private String name;
    private int age;
    private List<String> skilltree;
    private Address address;
}
