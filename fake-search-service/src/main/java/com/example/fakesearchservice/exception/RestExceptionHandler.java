package com.example.fakesearchservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Object> handleMethodNotSupport(Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "001");
        map.put("message", e.getMessage());
        map.put("timestamp", new Date());
        return new ResponseEntity<>(map, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<Object> handleDataNotFound(Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "002");
        map.put("message", e.getMessage());
        map.put("timestamp", new Date());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
