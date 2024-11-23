package com.hexaware.hotpot.service.impl;

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
        return restaurantRepository.save(restaurant);
    }
    
    @Override
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }
    
    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
    
    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        return restaurantRepository.findByCity(city);
    }
    
    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    
    @Override
    public void deactivateRestaurant(Long id) {
        restaurantRepository.findById(id).ifPresent(restaurant -> {
            restaurant.setIsActive(false);
            restaurantRepository.save(restaurant);
        });
    }
    
    @Override
    public void activateRestaurant(Long id) {
        restaurantRepository.findById(id).ifPresent(restaurant -> {
            restaurant.setIsActive(true);
            restaurantRepository.save(restaurant);
        });
    }
    
    @Override
    public List<Restaurant> getActiveRestaurants() {
        return restaurantRepository.findByIsActiveTrue();
    }
}