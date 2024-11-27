package com.hexaware.hotpot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.exception.ResourceNotFoundException;
import com.hexaware.hotpot.models.Order;
import com.hexaware.hotpot.models.Order.PaymentStatus;
import com.hexaware.hotpot.repository.OrderRepository;
import com.hexaware.hotpot.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    
    @Override
    public Order createOrder(Order order) {
        if (order == null || order.getUser() == null || order.getRestaurant() == null) {
            throw new BadRequestException(null, "Order, User, and Restaurant details must be provided.");
        }
        if (order.getDeliveryAddress() == null || order.getDeliveryAddress().trim().isEmpty()) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Delivery address must be provided.");
        }

        return orderRepository.save(order);
    }
    
    @Override
    public Optional<Order> getOrderById(Long id) {
        return Optional.of(orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id)));
    }
    
    @Override
    public List<Order> getOrdersByUser(Long userId) {
        List<Order> orders = orderRepository.findByUserUserId(userId);
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException("No orders found for user with id: " + userId);
        }
        return orders;
    }
    
    @Override
    public List<Order> getOrdersByRestaurant(Long restaurantId) {
        List<Order> orders = orderRepository.findByRestaurantRestaurantId(restaurantId);
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException("No orders found for restaurant with id: " + restaurantId);
        }
        return orders;
    }
    
    @Override
    public Order updateOrderStatus(Long id, Order.OrderStatus status) {
//        if (status == null) {
//            throw new BadRequestException("Order status must be provided.");
//        }
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }
    
    @Override
    public Order updatePaymentStatus(Long id, Order.PaymentStatus status) {
//        if (status == null) {
//            throw new BadRequestException("Payment status must be provided.");
//        }
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setPaymentStatus(status);
        return orderRepository.save(order);
    }
    
    @Override
    public List<Order> getOrdersByStatus(Order.OrderStatus status) {
//        if (status == null) {
//            throw new BadRequestException("Order status must be provided.");
//        }
        List<Order> orders = orderRepository.findByOrderStatus(status);
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException("No orders found with status: " + status);
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByPaymentStatus(PaymentStatus status) {
//        if (status == null) {
//            throw new BadRequestException("Payment status must be provided.");
//        }
        List<Order> orders = orderRepository.findByPaymentStatus(status);
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException("No orders found with payment status: " + status);
        }
        return orders;
    }
}

