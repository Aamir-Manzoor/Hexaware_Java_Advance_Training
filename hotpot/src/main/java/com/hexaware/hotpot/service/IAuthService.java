package com.hexaware.hotpot.service;

import com.hexaware.hotpot.dto.CustomerRegisterDTO;
import com.hexaware.hotpot.dto.JWTAuthResponse;
import com.hexaware.hotpot.dto.LoginDTO;
import com.hexaware.hotpot.dto.RestaurantRegisterDTO;

public interface IAuthService {

    /**
     * Handle login and return JWT authentication response.
     * @param dto Login data transfer object containing username and password
     * @return JWTAuthResponse containing JWT token and user details
     */
    JWTAuthResponse login(LoginDTO dto);

    /**
     * Register a new customer.
     * @param dto Customer registration data transfer object
     * @return A message indicating successful registration
     */
    String registerCustomer(CustomerRegisterDTO dto);

    /**
     * Register a new seller.
     * @param dto Seller registration data transfer object
     * @return A message indicating successful registration
     */
    String registerRestaurant(RestaurantRegisterDTO dto);
}