package com.hexaware.hotpot.service.impl;

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
        return cartItemRepository.save(cartItem);
    }

    @Override
    public Optional<CartItem> getCartItemById(Long id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public List<CartItem> getCartItemsByCart(Long cartId) {
        return cartItemRepository.findByCartCartId(cartId);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        if (cartItemRepository.existsById(cartItem.getCartItemId())) {
            return cartItemRepository.save(cartItem);
        }
        throw new RuntimeException("CartItem not found with id: " + cartItem.getCartItemId());
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public CartItem updateQuantity(Long id, int quantity) {
        Optional<CartItem> cartItemOpt = cartItemRepository.findById(id);
        if (cartItemOpt.isPresent()) {
            CartItem cartItem = cartItemOpt.get();
            cartItem.setQuantity(quantity);
            return cartItemRepository.save(cartItem);
        }
        throw new RuntimeException("CartItem not found with id: " + id);
    }

    @Override
    public CartItem updateSpecialInstructions(Long id, String instructions) {
        Optional<CartItem> cartItemOpt = cartItemRepository.findById(id);
        if (cartItemOpt.isPresent()) {
            CartItem cartItem = cartItemOpt.get();
            cartItem.setSpecialInstructions(instructions);
            return cartItemRepository.save(cartItem);
        }
        throw new RuntimeException("CartItem not found with id: " + id);
    }
}