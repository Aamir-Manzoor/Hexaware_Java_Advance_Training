package com.hexaware.hotpot.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RestaurantDTO {

	private Long restaurantId;

	private String name;

	private String phoneNumber;

	private String city;

	private LocalDateTime createdAt;

	private Boolean isActive;

	// Constructor
	public RestaurantDTO(Long restaurantId, String name, String phoneNumber, String city, LocalDateTime createdAt,
			Boolean isActive) {
		this.restaurantId = restaurantId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.createdAt = createdAt;
		this.isActive = isActive;
	}

	// Getters
	public Long getRestaurantId() {
		return restaurantId;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	// Setters
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "RestaurantDTO{" + "restaurantId=" + restaurantId + ", name='" + name;

	}
}
