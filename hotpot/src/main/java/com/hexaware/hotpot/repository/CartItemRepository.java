package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.models.CartItem;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
}
