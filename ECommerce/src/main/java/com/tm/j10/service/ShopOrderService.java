package com.tm.j10.service;

import com.tm.j10.domain.ShopOrder;
import com.tm.j10.domain.enumeration.OrderStatus;
import com.tm.j10.repository.ShopOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopOrderService {
    private ShopOrderRepository shopOrderRepository;

    public ShopOrderService(ShopOrderRepository shopOrderRepository) {
        this.shopOrderRepository = shopOrderRepository;
    }

    private void validateNumber(Long number) {
        if (number == 0) {
            throw new RuntimeException("Invalid number: 0 is invalid");
        }
        if (number < 0) {
            throw new RuntimeException("Invalid number: can not be negative");
        }
    }

    public void closeOrder(Long id) {
        this.validateNumber(id);
        Optional<ShopOrder> opOrder = shopOrderRepository.findById(id);
        if (opOrder.isPresent()) {
            ShopOrder currentShopOrder = opOrder.get();
            OrderStatus currentStatus = currentShopOrder.getOrderStatus();
            if (currentStatus.equals(OrderStatus.CANCEL_BY_SHOP) ||
                currentStatus.equals(OrderStatus.COMPLETE) ||
                currentStatus.equals(OrderStatus.CANCEL_BY_USER)) {
                throw new RuntimeException(currentStatus + " :invalid status");
            }

            currentShopOrder.setOrderStatus(OrderStatus.CANCEL_BY_USER);
            shopOrderRepository.save(currentShopOrder);
        } else {
            throw new RuntimeException("Not found Order");
        }
    }

    public void processOrder(Long orderId) {
        this.validateNumber(orderId);
        var optOrder = this.shopOrderRepository.findById(orderId);
        if (optOrder.isPresent()){
            ShopOrder currentShopOrder = optOrder.get();
            if (currentShopOrder.getOrderStatus().equals(OrderStatus.CREATED)){
                currentShopOrder.setOrderStatus(OrderStatus.PROCESS);
                this.shopOrderRepository.save(currentShopOrder);
            } else {
                throw new RuntimeException("Invalid order status");
            }
        } else {
            throw new RuntimeException("Not found order");
        }
    }
}