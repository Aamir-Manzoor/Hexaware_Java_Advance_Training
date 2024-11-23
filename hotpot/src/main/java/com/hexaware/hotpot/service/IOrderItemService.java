package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.OrderItem;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    Optional<OrderItem> getOrderItemById(Long id);
    List<OrderItem> getOrderItemsByOrder(Long orderId);
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long id);
    List<OrderItem> createOrderItems(List<OrderItem> orderItems);
}