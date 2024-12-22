package com.hotpot.service;

import java.util.List;

import com.hotpot.Exception.FoodException;
import com.hotpot.Exception.RestaurantException;
import com.hotpot.model.Category;
import com.hotpot.model.Food;
import com.hotpot.model.Restaurant;
import com.hotpot.request.CreateFoodRequest;

public interface FoodService {

	public Food createFood(CreateFoodRequest req,Category category,
						   Restaurant restaurant) throws FoodException, RestaurantException;

	void deleteFood(Long foodId) throws FoodException;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
			boolean isVegetarian, boolean isNonveg, boolean isSeasonal,String foodCategory) throws FoodException;
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws FoodException;

	public Food updateAvailibilityStatus(Long foodId) throws FoodException;
}
