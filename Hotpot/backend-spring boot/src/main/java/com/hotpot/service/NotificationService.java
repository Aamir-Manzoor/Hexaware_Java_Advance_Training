package com.hotpot.service;

import java.util.List;

import com.hotpot.model.Notification;
import com.hotpot.model.Order;
import com.hotpot.model.Restaurant;
import com.hotpot.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
