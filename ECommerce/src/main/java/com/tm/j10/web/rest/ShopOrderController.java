package com.tm.j10.web.rest;

import com.tm.j10.service.ShopOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/public/orders")
public class ShopOrderController {
    private ShopOrderService shopOrderService;

    public ShopOrderController(ShopOrderService shopOrderService) {
        this.shopOrderService = shopOrderService;
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> closeOrder(@PathVariable Long id) {
        try {
            this.shopOrderService.closeOrder(id);
            return ResponseEntity.ok("Close order succeed");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/process")
    public ResponseEntity<String> processOrder(@PathVariable Long id) {
        try {
            this.shopOrderService.processOrder(id);
            return ResponseEntity.ok("Process order succeed");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
