package com.hexaware.hotpot.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class OrderDTO {
	@NotNull(message = "Order ID cannot be null")
	@Positive(message = "Order ID must be a positive number")
	private Long orderId;

	@NotEmpty(message = "Delivery address cannot be blank")
	@Size(max = 255, message = "Delivery address cannot exceed 255 characters")
	private String deliveryAddress;

	@NotNull(message = "Total amount cannot be null")
	@DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than zero")
	private BigDecimal totalAmount;

	@NotBlank(message = "Order status cannot be blank")
	private String orderStatus;

	@NotEmpty(message = "Payment status cannot be blank")
	private String paymentStatus;

	@NotNull(message = "Creation time cannot be null")
	private LocalDateTime createdAt;

	// Constructor
	public OrderDTO(Long orderId, String deliveryAddress, BigDecimal totalAmount, String orderStatus,
			String paymentStatus, LocalDateTime createdAt) {
		this.orderId = orderId;
		this.deliveryAddress = deliveryAddress;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.createdAt = createdAt;
	}

	// Getters
	public Long getOrderId() {
		return orderId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	// Setters
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "OrderDTO{" + "orderId=" + orderId + ", deliveryAddress='" + deliveryAddress + '\'' + ", totalAmount="
				+ totalAmount + ", orderStatus='" + orderStatus + '\'' + ", paymentStatus='" + paymentStatus + '\''
				+ ", createdAt=" + createdAt + '}';
	}
}
