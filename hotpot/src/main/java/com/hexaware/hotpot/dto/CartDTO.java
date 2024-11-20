package com.hexaware.hotpot.dto;

import java.util.List;

import com.hexaware.hotpot.models.CartItem;
import com.hexaware.hotpot.models.Restaurant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartDTO {

	@NotNull(message = "Cart ID cannot be null")
	@Positive(message = "Cart ID must be a positive number")
    private Long cartId;

    @NotNull(message = "Restaurant cannot be null")
    private Restaurant restaurant;

    @NotEmpty(message = "Cart items cannot be empty")
    private List<CartItem> cartItems;

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Long cartId, Restaurant restaurant, List<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.restaurant = restaurant;
		this.cartItems = cartItems;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", restaurant=" + restaurant + ", cartItems=" + cartItems + "]";
	}
	 
	 
}
