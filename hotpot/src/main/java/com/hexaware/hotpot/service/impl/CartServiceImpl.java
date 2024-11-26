package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.exception.ResourceNotFoundException;
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
//    	if (cart.getUser() == null || cart.getRestaurant() == null) {
//            throw new BadRequestException("Cart must have associated User and Restaurant.");
//        }
        return cartRepository.save(cart);
    }
    
    @Override
    public Optional<Cart> getCartById(Long id) {
    	 return Optional.of(cartRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id)));
    }
    
    @Override
    public List<Cart> getCartsByUser(Long userId) {
    	List<Cart> carts = cartRepository.findByUserUserId(userId);
        if (carts.isEmpty()) {
            throw new ResourceNotFoundException("No carts found for User ID: " + userId);
        }
        return carts;
    }
    
    @Override
    public Optional<Cart> getCartByUserAndRestaurant(Long userId, Long restaurantId) {
    	return Optional.of(cartRepository.findByUserUserIdAndRestaurantRestaurantId(userId, restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cart not found for User ID: " + userId + " and Restaurant ID: " + restaurantId)));
    }
    
    @Override
    public Cart updateCart(Cart cart) {
    	if (cart.getCartId() == null || !cartRepository.existsById(cart.getCartId())) {
            throw new ResourceNotFoundException("Cannot update. Cart not found with id: " + cart.getCartId());
        }
        return cartRepository.save(cart);
    }
    
    @Override
    public void deleteCart(Long id) {
    	if (!cartRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. Cart not found with id: " + id);
        }
        cartRepository.deleteById(id);
    }
    
    @Override
    public void clearCart(Long id) {
    	Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot clear. Cart not found with id: " + id));
//        if (cart.getCartItems().isEmpty()) {
//            throw new BadRequestException("Cart is already empty.");
//        }
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }
}
