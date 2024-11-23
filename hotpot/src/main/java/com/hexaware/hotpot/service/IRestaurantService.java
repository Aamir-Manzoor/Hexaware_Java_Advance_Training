package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.Restaurant;
import java.util.List;
import java.util.Optional;

public interface IRestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);
    Optional<Restaurant> getRestaurantById(Long id);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantsByCity(String city);
    Restaurant updateRestaurant(Restaurant restaurant);
    void deactivateRestaurant(Long id);
    void activateRestaurant(Long id);
    List<Restaurant> getActiveRestaurants();
}