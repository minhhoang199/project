package com.microservices.customer.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "SECURITY/api/security/test")
public interface TestClient {

    @GetMapping("/hello")
    ResponseEntity<String> getHello(@RequestHeader("Authorization") String token);

}
