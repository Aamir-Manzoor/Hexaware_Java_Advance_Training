package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.models.Cart;
import com.hexaware.hotpot.repository.CartRepository;
import com.hexaware.hotpot.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {
    
    @Autowired
    private CartRepository cartRepository;
    
    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }
    
    @Override
    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }
    
    @Override
    public List<Cart> getCartsByUser(Long userId) {
        return cartRepository.findByUserUserId(userId);
    }
    
    @Override
    public Optional<Cart> getCartByUserAndRestaurant(Long userId, Long restaurantId) {
        return cartRepository.findByUserUserIdAndRestaurantRestaurantId(userId, restaurantId);
    }
    
    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }
    
    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
    
    @Override
    public void clearCart(Long id) {
        cartRepository.findById(id).ifPresent(cart -> {
            cart.getCartItems().clear();
            cartRepository.save(cart);
        });
    }
}
