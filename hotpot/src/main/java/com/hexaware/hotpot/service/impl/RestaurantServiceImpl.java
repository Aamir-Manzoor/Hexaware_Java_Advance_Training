package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.exception.ResourceNotFoundException;
import com.hexaware.hotpot.models.Restaurant;
import com.hexaware.hotpot.repository.RestaurantRepository;
import com.hexaware.hotpot.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
    	if (restaurant == null || restaurant.getName() == null || restaurant.getCity() == null) {
            throw new BadRequestException("Restaurant name and city must be provided.");
        }
        return restaurantRepository.save(restaurant);
    }
    
    @Override
    public Optional<Restaurant> getRestaurantById(Long id) {
    	 return Optional.of(restaurantRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id)));
     }
    
    @Override
    public List<Restaurant> getAllRestaurants() {
    	List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.isEmpty()) {
            throw new ResourceNotFoundException("No restaurants found.");
        }
        return restaurants;
        
    }
    
    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
    	if (city == null || city.isEmpty()) {
            throw new BadRequestException("City name must be provided.");
        }
        List<Restaurant> restaurants = restaurantRepository.findByCity(city);
        if (restaurants.isEmpty()) {
            throw new ResourceNotFoundException("No restaurants found in city: " + city);
        }
        return restaurants;
    }
    
    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
    	if (restaurant == null || restaurant.getRestaurantId() == null) {
            throw new BadRequestException("Restaurant ID and details must be provided.");
        }
        if (!restaurantRepository.existsById(restaurant.getRestaurantId())) {
            throw new ResourceNotFoundException("Restaurant not found with id: " + restaurant.getRestaurantId());
        }
        return restaurantRepository.save(restaurant);
    }
    
    @Override
    public void deactivateRestaurant(Long id) {
    	 Restaurant restaurant = restaurantRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
         restaurant.setIsActive(false);
         restaurantRepository.save(restaurant);
     }
    
    @Override
    public void activateRestaurant(Long id) {
    	Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        restaurant.setIsActive(true);
        restaurantRepository.save(restaurant);
    }
    
    @Override
    public List<Restaurant> getActiveRestaurants() {
    	 List<Restaurant> activeRestaurants = restaurantRepository.findByIsActiveTrue();
         if (activeRestaurants.isEmpty()) {
             throw new ResourceNotFoundException("No active restaurants found.");
         }
         return activeRestaurants;
    }
}