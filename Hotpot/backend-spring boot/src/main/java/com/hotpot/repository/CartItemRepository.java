package com.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotpot.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
