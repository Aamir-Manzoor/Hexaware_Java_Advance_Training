package com.hexaware.hotpot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.models.Order;
import com.hexaware.hotpot.models.Order.OrderStatus;
import com.hexaware.hotpot.models.Order.PaymentStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserUserId(Long userId);
    List<Order> findByRestaurantRestaurantId(Long restaurantId);
    List<Order> findByOrderStatus(OrderStatus status);
    List<Order> findByPaymentStatus(PaymentStatus status);
}

