package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.models.Order;
import com.hexaware.hotpot.models.Order.PaymentStatus;
import com.hexaware.hotpot.repository.OrderRepository;
import com.hexaware.hotpot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    
    @Override
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserUserId(userId);
    }
    
    @Override
    public List<Order> getOrdersByRestaurant(Long restaurantId) {
        return orderRepository.findByRestaurantRestaurantId(restaurantId);
    }
    
    @Override
    public Order updateOrderStatus(Long id, Order.OrderStatus status) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setOrderStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
    
    @Override
    public Order updatePaymentStatus(Long id, Order.PaymentStatus status) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setPaymentStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
    
    @Override
    public List<Order> getOrdersByStatus(Order.OrderStatus status) {
        return orderRepository.findByOrderStatus(status);
    }

	@Override
	public List<Order> getOrdersByPaymentStatus(PaymentStatus status) {
		// TODO Auto-generated method stub
		return null;
	}
    
}