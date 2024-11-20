package com.hexaware.hotpot.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserDTO {
	@NotNull(message = "User ID cannot be null")
	@Positive(message = "User ID must be a positive number")
	private Long userId;

	@NotBlank(message = "Username cannot be blank")
	@Size(max = 50, message = "Username cannot exceed 50 characters")
	private String username;

	@NotBlank(message = "Role cannot be blank")
	private String role;

	@NotNull(message = "Creation time cannot be null")
	private LocalDateTime createdAt;

	@NotNull(message = "Active status cannot be null")
	private Boolean isActive;

	// Constructor
	public UserDTO(Long userId, String username, String role, LocalDateTime createdAt, Boolean isActive) {
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.createdAt = createdAt;
		this.isActive = isActive;
	}

	// Getters
	public Long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	// Setters
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", role=" + role + ", createdAt=" + createdAt
				+ ", isActive=" + isActive + "]";
	}

}
