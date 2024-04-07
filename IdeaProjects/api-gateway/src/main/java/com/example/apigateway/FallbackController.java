package com.example.apigateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/customerFallback")
    public ResponseEntity<String> customerFallback(){
        return ResponseEntity.ok("Customer take too long response");
    }

    @RequestMapping("/securityFallback")
    public ResponseEntity<String> securityFallback(){
        return ResponseEntity.ok("Security take too long response");
    }
}
