package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.models.MenuItem;
import com.hexaware.hotpot.repository.MenuItemRepository;
import com.hexaware.hotpot.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements IMenuItemService {
    
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
    
    @Override
    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }
    
    @Override
    public List<MenuItem> getMenuItemsByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurantRestaurantIdAndIsAvailableTrue(restaurantId);
    }
    
    @Override
    public List<MenuItem> getMenuItemsByCategory(Long restaurantId, String category) {
        return menuItemRepository.findByRestaurantRestaurantIdAndCategory(restaurantId, category);
    }
    
    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
    
    @Override
    public void toggleAvailability(Long id) {
        menuItemRepository.findById(id).ifPresent(menuItem -> {
            menuItem.setIsAvailable(!menuItem.getIsAvailable());
            menuItemRepository.save(menuItem);
        });
    }
    
    @Override
    public List<MenuItem> getAvailableItems(Long restaurantId) {
        return menuItemRepository.findByRestaurantRestaurantIdAndIsAvailableTrue(restaurantId);
    }
}