package com.hotpot.service;

import java.util.List;

import com.hotpot.Exception.RestaurantException;
import com.hotpot.model.Category;

public interface CategoryService {
	
	public Category createCategory (String name,Long userId) throws RestaurantException;
	public List<Category> findCategoryByRestaurantId(Long restaurantId) throws RestaurantException;
	public Category findCategoryById(Long id) throws RestaurantException;

}