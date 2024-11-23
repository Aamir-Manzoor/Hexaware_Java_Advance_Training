package com.hexaware.hotpot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.models.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUserUserId(Long userId);

	Optional<Cart> findByUserUserIdAndRestaurantRestaurantId(Long userId, Long restaurantId);
    
}
