package com.hotpot.service;

import com.hotpot.Exception.CartException;
import com.hotpot.Exception.CartItemException;
import com.hotpot.Exception.FoodException;
import com.hotpot.Exception.UserException;
import com.hotpot.model.Cart;
import com.hotpot.model.CartItem;
import com.hotpot.model.Food;
import com.hotpot.model.User;
import com.hotpot.request.AddCartItemRequest;
import com.hotpot.request.UpdateCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
