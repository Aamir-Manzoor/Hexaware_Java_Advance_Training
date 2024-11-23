package com.hexaware.hotpot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.models.MenuItem;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	List<MenuItem> findByRestaurantRestaurantIdAndCategory(Long restaurantId, String category);


	List<MenuItem> findByRestaurantRestaurantIdAndIsAvailableTrue(Long restaurantId);
    
}
