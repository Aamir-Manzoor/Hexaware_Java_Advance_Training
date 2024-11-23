package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.MenuItem;
import java.util.List;
import java.util.Optional;

public interface IMenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);
    Optional<MenuItem> getMenuItemById(Long id);
    List<MenuItem> getMenuItemsByRestaurant(Long restaurantId);
    List<MenuItem> getMenuItemsByCategory(Long restaurantId, String category);
    MenuItem updateMenuItem(MenuItem menuItem);
    void toggleAvailability(Long id);
    List<MenuItem> getAvailableItems(Long restaurantId);
}