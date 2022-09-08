package com.tm.j10.service;

import com.tm.j10.domain.ShopOrder;
import com.tm.j10.domain.enumeration.OrderStatus;
import com.tm.j10.repository.CustomerRepository;
import com.tm.j10.repository.ShopOrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopOrderService {
    private ShopOrderRepository shopOrderRepository;
    private CustomerRepository customerRepository;

    public ShopOrderService(ShopOrderRepository shopOrderRepository, CustomerRepository customerRepository) {
        this.shopOrderRepository = shopOrderRepository;
        this.customerRepository = customerRepository;
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
        if (optOrder.isPresent()) {
            ShopOrder currentShopOrder = optOrder.get();
            if (currentShopOrder.getOrderStatus().equals(OrderStatus.CREATED)) {
                currentShopOrder.setOrderStatus(OrderStatus.PROCESS);
                this.shopOrderRepository.save(currentShopOrder);
            } else {
                throw new RuntimeException("Invalid order status");
            }
        } else {
            throw new RuntimeException("Not found order");
        }
    }

    public void closeOrderByAdmin(Long id) {
        this.validateNumber(id);
        Optional<ShopOrder> shopOrder = shopOrderRepository.findById(id);
        if (shopOrder.isPresent()) {
            ShopOrder currentShopOder = shopOrder.get();
            OrderStatus currentStatus = currentShopOder.getOrderStatus();
            if (currentStatus.equals(OrderStatus.CANCEL_BY_SHOP) ||
                currentStatus.equals(OrderStatus.COMPLETE) ||
                currentStatus.equals(OrderStatus.CANCEL_BY_USER)) {
                throw new RuntimeException(currentStatus + " :invalid status");
            }
            currentShopOder.setOrderStatus(OrderStatus.CANCEL_BY_SHOP);
            shopOrderRepository.save(currentShopOder);
        } else {
            throw new RuntimeException("Not found Order");
        }
    }

    public Page<ShopOrder> getAllByCustomerId(Long customerId, Pageable pageable) {
        this.validateNumber(customerId);
        var customerOtp = this.customerRepository.findById(customerId);
        if (customerOtp.isPresent()) {
            return this.shopOrderRepository.findByCustomerId(customerId, pageable);
        } else {
            throw new RuntimeException("Not found customer");
        }
    }

    public Page<ShopOrder> getAllByCustomerIdAndOrderStatus(Long customerId, OrderStatus orderStatus, Pageable pageable) {
        this.validateNumber(customerId);
        var customerOtp = this.customerRepository.findById(customerId);
        if (customerOtp.isPresent()) {
            return this.shopOrderRepository.findByCustomerIdAndOrderStatus(customerId, orderStatus, pageable);
        } else {
            throw new RuntimeException("Not found customer");
        }
    }

    public Page<ShopOrder> getAllShopOrderByAdmin(Pageable pageable) {
        var ret = this.shopOrderRepository.findAll(pageable);
        return ret;
    }

    public Page<ShopOrder> getAllShopOrderByOrderStatus(OrderStatus orderStatus, Pageable pageable) {
        var ret = this.shopOrderRepository.findAllByOrderStatus(orderStatus, pageable);
        return ret;
    }
}
