package com.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotpot.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
