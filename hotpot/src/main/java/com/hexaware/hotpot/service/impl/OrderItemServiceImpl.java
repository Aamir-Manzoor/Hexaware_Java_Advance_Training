package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.models.OrderItem;
import com.hexaware.hotpot.repository.OrderItemRepository;
import com.hexaware.hotpot.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements IOrderItemService {
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    
    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }
    
    @Override
    public List<OrderItem> getOrderItemsByOrder(Long orderId) {
        return orderItemRepository.findByOrderOrderId(orderId);
    }
    
    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    
    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
    
    @Override
    public List<OrderItem> createOrderItems(List<OrderItem> orderItems) {
        return orderItemRepository.saveAll(orderItems);
    }
}