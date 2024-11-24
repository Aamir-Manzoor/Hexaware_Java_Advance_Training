package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.exception.ResourceNotFoundException;
import com.hexaware.hotpot.models.CartItem;
import com.hexaware.hotpot.repository.CartItemRepository;
import com.hexaware.hotpot.service.ICartItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements ICartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem addCartItem(CartItem cartItem) {
    	 try {
             return cartItemRepository.save(cartItem);
         } catch (Exception e) {
             throw new RuntimeException("An error occurred while adding the CartItem", e);
         }
    }

    @Override
    public Optional<CartItem> getCartItemById(Long id) {
    	return Optional.of(cartItemRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("CartItem not found with id: " + id);
                }));
    }

    @Override
    public List<CartItem> getCartItemsByCart(Long cartId){
    	List<CartItem> cartItems = cartItemRepository.findByCartCartId(cartId);
        if (cartItems.isEmpty()) {
            throw new ResourceNotFoundException("No CartItems found for Cart ID: " + cartId);
        }
        return cartItems;
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        if (cartItemRepository.existsById(cartItem.getCartItemId())) {
            return cartItemRepository.save(cartItem);
        }
        throw new ResourceNotFoundException("CartItem not found with id: " + cartItem.getCartItemId());
    }

    @Override
    public void deleteCartItem(Long id) {
    	if (!cartItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("CartItem not found with id: " + id);
        }
        cartItemRepository.deleteById(id);
    }

    @Override
    public CartItem updateQuantity(Long id, int quantity) {
    	CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + id));
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateSpecialInstructions(Long id, String instructions) {
        Optional<CartItem> cartItemOpt = cartItemRepository.findById(id);
        if (cartItemOpt.isPresent()) {
            CartItem cartItem = cartItemOpt.get();
            cartItem.setSpecialInstructions(instructions);
            return cartItemRepository.save(cartItem);
        }
        throw new ResourceNotFoundException("CartItem not found with id: " + id);
    }
}