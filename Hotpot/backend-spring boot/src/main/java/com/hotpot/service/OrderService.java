package com.hotpot.service;

import java.util.List;

import com.hotpot.Exception.CartException;
import com.hotpot.Exception.OrderException;
import com.hotpot.Exception.RestaurantException;
import com.hotpot.Exception.UserException;
import com.hotpot.model.Order;
import com.hotpot.model.PaymentResponse;
import com.hotpot.model.User;
import com.hotpot.request.CreateOrderRequest;
import com.stripe.exception.StripeException;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
