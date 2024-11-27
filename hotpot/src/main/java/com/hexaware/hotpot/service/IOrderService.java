package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.Order;
import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Order createOrder(Order order);
    Optional<Order> getOrderById(Long id);
    List<Order> getOrdersByUser(Long userId);
    List<Order> getOrdersByRestaurant(Long restaurantId);
    Order updateOrderStatus(Long id, Order.OrderStatus status);
    Order updatePaymentStatus(Long id, Order.PaymentStatus status);
    List<Order> getOrdersByStatus(Order.OrderStatus status);
    List<Order> getOrdersByPaymentStatus(Order.PaymentStatus status);
}

