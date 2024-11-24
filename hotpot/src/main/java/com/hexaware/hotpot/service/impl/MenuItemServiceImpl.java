package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.exception.ResourceNotFoundException;
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
    	if (menuItem.getRestaurant() == null || menuItem.getCategory() == null) {
            throw new BadRequestException("MenuItem must have a valid Restaurant and Category.");
        }
        return menuItemRepository.save(menuItem);
    }

    
    @Override
    public Optional<MenuItem> getMenuItemById(Long id) {
    	return Optional.of(menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found with id: " + id)));
    }
    
    @Override
    public List<MenuItem> getMenuItemsByRestaurant(Long restaurantId) {
    	List<MenuItem> menuItems = menuItemRepository.findByRestaurantRestaurantIdAndIsAvailableTrue(restaurantId);
        if (menuItems.isEmpty()) {
            throw new ResourceNotFoundException("No available MenuItems found for Restaurant ID: " + restaurantId);
        }
        return menuItems;
    }
    
    @Override
    public List<MenuItem> getMenuItemsByCategory(Long restaurantId, String category) {
    	List<MenuItem> menuItems = menuItemRepository.findByRestaurantRestaurantIdAndCategory(restaurantId, category);
        if (menuItems.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No MenuItems found for Restaurant ID: " + restaurantId + " in Category: " + category);
        }
        return menuItems;
    }
    
    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
    	if (menuItem.getMenuItemId() == null || !menuItemRepository.existsById(menuItem.getMenuItemId())) {
            throw new ResourceNotFoundException("Cannot update. MenuItem not found with id: " + menuItem.getMenuItemId());
        }
        return menuItemRepository.save(menuItem);
    }
    
    @Override
    public void toggleAvailability(Long id) {
    	MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem not found with id: " + id));
        menuItem.setIsAvailable(!menuItem.getIsAvailable());
        menuItemRepository.save(menuItem);
    }
    
    @Override
    public List<MenuItem> getAvailableItems(Long restaurantId) {
    	List<MenuItem> availableItems = menuItemRepository.findByRestaurantRestaurantIdAndIsAvailableTrue(restaurantId);
        if (availableItems.isEmpty()) {
            throw new ResourceNotFoundException("No available MenuItems found for Restaurant ID: " + restaurantId);
        }
        return availableItems;
    }
}