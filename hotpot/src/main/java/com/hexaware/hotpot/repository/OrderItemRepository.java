package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.models.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
