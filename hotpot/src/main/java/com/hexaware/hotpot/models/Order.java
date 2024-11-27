package com.hexaware.hotpot.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.hexaware.hotpot.models.OrderStatusDeserializer;
//import com.hexaware.hotpot.models.PaymentStatusDeserializer;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
    
    @Column(nullable = false, length = 255)
    private String deliveryAddress;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @JsonDeserialize(using = OrderStatusDeserializer.class)
    private OrderStatus orderStatus = OrderStatus.PENDING;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @JsonDeserialize(using = PaymentStatusDeserializer.class)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    
    public enum OrderStatus {
        PENDING, CONFIRMED, DELIVERED, CANCELLED
    }
    
    public enum PaymentStatus {
        PENDING, COMPLETED, UNPAID
    }

    // Constructors
    public Order() {
        this.createdAt = LocalDateTime.now();
    }

   

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}