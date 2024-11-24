package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.exception.ResourceNotFoundException;
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
    	if (orderItem.getOrder() == null || orderItem.getMenuItem() == null) {
            throw new BadRequestException("OrderItem must have an associated Order and MenuItem.");
        }
        return orderItemRepository.save(orderItem);
    }
    
    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
    	 return Optional.of(orderItemRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found with id: " + id)));
     }
    
    @Override
    public List<OrderItem> getOrderItemsByOrder(Long orderId) {
    	List<OrderItem> orderItems = orderItemRepository.findByOrderOrderId(orderId);
        if (orderItems.isEmpty()) {
            throw new ResourceNotFoundException("No OrderItems found for Order ID: " + orderId);
        }
        return orderItems;
    }
    
    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
    	if (orderItem.getOrderItemId() == null || !orderItemRepository.existsById(orderItem.getOrderItemId())) {
            throw new ResourceNotFoundException(
                    "Cannot update. OrderItem not found with id: " + orderItem.getOrderItemId());
        }
        return orderItemRepository.save(orderItem);
    }
    
    @Override
    public void deleteOrderItem(Long id) {
    	 if (!orderItemRepository.existsById(id)) {
             throw new ResourceNotFoundException("Cannot delete. OrderItem not found with id: " + id);
         }
         orderItemRepository.deleteById(id);
    }
    
    @Override
    public List<OrderItem> createOrderItems(List<OrderItem> orderItems) {
    	if (orderItems == null || orderItems.isEmpty()) {
            throw new BadRequestException("OrderItems list cannot be null or empty.");
        }
        orderItems.forEach(item -> {
            if (item.getOrder() == null || item.getMenuItem() == null) {
                throw new BadRequestException("Each OrderItem must have an associated Order and MenuItem.");
            }
        });
        return orderItemRepository.saveAll(orderItems);
    }
}