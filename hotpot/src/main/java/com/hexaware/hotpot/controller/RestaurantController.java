//package com.hexaware.hotpot.controller;
//
//import com.hexaware.hotpot.models.Restaurant;
//import com.hexaware.hotpot.service.IRestaurantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/restaurants")
//public class RestaurantController {
//    
//    @Autowired
//    private IRestaurantService restaurantService;
//    
//    @PostMapping
//    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
//        return ResponseEntity.ok(restaurantService.createRestaurant(restaurant));
//    }
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
//        return restaurantService.getRestaurantById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    @GetMapping
//    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
//        return ResponseEntity.ok(restaurantService.getAllRestaurants());
//    }
//    
//    @GetMapping("/city/{city}")
//    public ResponseEntity<List<Restaurant>> getRestaurantsByCity(@PathVariable String city) {
//        return ResponseEntity.ok(restaurantService.getRestaurantsByCity(city));
//    }
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, 
//                                                     @RequestBody Restaurant restaurant) {
//        restaurant.setRestaurantId(id);
//        return ResponseEntity.ok(restaurantService.updateRestaurant(restaurant));
//    }
//    
//    @PatchMapping("/{id}/deactivate")
//    public ResponseEntity<Void> deactivateRestaurant(@PathVariable Long id) {
//        restaurantService.deactivateRestaurant(id);
//        return ResponseEntity.ok().build();
//    }
//    
//    @PatchMapping("/{id}/activate")
//    public ResponseEntity<Void> activateRestaurant(@PathVariable Long id) {
//        restaurantService.activateRestaurant(id);
//        return ResponseEntity.ok().build();
//    }
//    
//    @GetMapping("/active")
//    public ResponseEntity<List<Restaurant>> getActiveRestaurants() {
//        return ResponseEntity.ok(restaurantService.getActiveRestaurants());
//    }
//}