package com.example.cloudconfigserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class main {
    public static void main(String[] args) {
        String objString = "{ \"name\":\"David\", \"age\": 10, \"skilltree\":[ \"Java\", \"Python\", \"JavaScript\" ], \"address\":{ \"street\":\"Street\", \"streetNo\":\"123\" } }";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ObjectTest objectTest = objectMapper.readValue(objString, ObjectTest.class);
            System.out.println(objectTest.getName());
            System.out.println(objectTest.getAddress().getStreet());
            System.out.println(objectTest.getAge());
            System.out.println(objectTest.getSkilltree());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
