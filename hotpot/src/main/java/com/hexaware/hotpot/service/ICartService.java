package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.Cart;
import java.util.List;
import java.util.Optional;

public interface ICartService {
    Cart createCart(Cart cart);
    Optional<Cart> getCartById(Long id);
    List<Cart> getCartsByUser(Long userId);
    Optional<Cart> getCartByUserAndRestaurant(Long userId, Long restaurantId);
    Cart updateCart(Cart cart);
    void deleteCart(Long id);
    void clearCart(Long id);
}
