package com.hotpot.service;

import java.util.List;

import com.hotpot.Exception.FoodException;
import com.hotpot.Exception.RestaurantException;
import com.hotpot.model.Food;
import com.hotpot.model.IngredientCategory;
import com.hotpot.model.IngredientsItem;
import com.hotpot.repository.IngredientsCategoryRepository;

public interface IngredientsService {
	
	public IngredientCategory createIngredientsCategory(
			String name,Long restaurantId) throws RestaurantException;

	public IngredientCategory findIngredientsCategoryById(Long id) throws Exception;

	public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception;
	
	public List<IngredientsItem> findRestaurantsIngredients(
			Long restaurantId);

	
	public IngredientsItem createIngredientsItem(Long restaurantId, 
			String ingredientName,Long ingredientCategoryId) throws Exception;

	public IngredientsItem updateStoke(Long id) throws Exception;
	
}
