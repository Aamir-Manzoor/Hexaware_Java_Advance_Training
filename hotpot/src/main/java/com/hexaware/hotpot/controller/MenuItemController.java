package com.hexaware.hotpot.controller;

import com.hexaware.hotpot.models.MenuItem;
import com.hexaware.hotpot.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {
    
    @Autowired
    private IMenuItemService menuItemService;
    
    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.createMenuItem(menuItem));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable Long id) {
        return menuItemService.getMenuItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItem>> getMenuItemsByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuItemService.getMenuItemsByRestaurant(restaurantId));
    }
    
    @GetMapping("/restaurant/{restaurantId}/category/{category}")
    public ResponseEntity<List<MenuItem>> getMenuItemsByCategory(
            @PathVariable Long restaurantId,
            @PathVariable String category) {
        return ResponseEntity.ok(menuItemService.getMenuItemsByCategory(restaurantId, category));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, 
                                                 @RequestBody MenuItem menuItem) {
        menuItem.setMenuItemId(id);
        return ResponseEntity.ok(menuItemService.updateMenuItem(menuItem));
    }
    
    @PatchMapping("/{id}/toggle-availability")
    public ResponseEntity<Void> toggleAvailability(@PathVariable Long id) {
        menuItemService.toggleAvailability(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/restaurant/{restaurantId}/available")
    public ResponseEntity<List<MenuItem>> getAvailableItems(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuItemService.getAvailableItems(restaurantId));
    }
}