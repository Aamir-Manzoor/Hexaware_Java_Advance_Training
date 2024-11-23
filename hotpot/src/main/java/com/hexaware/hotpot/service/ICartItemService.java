package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.CartItem;
import java.util.List;
import java.util.Optional;

public interface ICartItemService {
    CartItem addCartItem(CartItem cartItem);
    Optional<CartItem> getCartItemById(Long id);
    List<CartItem> getCartItemsByCart(Long cartId);
    CartItem updateCartItem(CartItem cartItem);
    void deleteCartItem(Long id);
    CartItem updateQuantity(Long id, int quantity);
    CartItem updateSpecialInstructions(Long id, String instructions);
}