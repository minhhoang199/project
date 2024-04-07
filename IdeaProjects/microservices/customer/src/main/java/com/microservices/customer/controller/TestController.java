package com.microservices.customer.controller;

import com.microservices.customer.clients.TestClient;
import com.microservices.customer.constant.URLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/v1/test")
public class TestController {
    @Autowired
    private TestClient testClient;

    @Value("${microservice.customer.endpoints.endpoint.uri}")
    private String URL;

    @GetMapping("/getHello")
    public ResponseEntity<String> getHello(@RequestHeader("Authorization") String token) {
        try {
            System.out.println(URL);
            return ResponseEntity.ok(this.testClient.getHello(token).getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }

}
