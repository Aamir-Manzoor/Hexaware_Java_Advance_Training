package com.hexaware.hotpot.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
 
    private String username;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(length = 15)
    private String phoneNumber;
    
    @Column(nullable = false, length = 50)
    private String city;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @Column
    private Boolean isActive = true;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems = new ArrayList<>();

    // Add this no-argument constructor
    public Restaurant() {
    }

    public Restaurant(Long restaurantId, String username, String name, String phoneNumber, String city,
            LocalDateTime createdAt, Boolean isActive, List<MenuItem> menuItems) {
        this.restaurantId = restaurantId;
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.menuItems = menuItems;
    }

    // Getters and setters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId + ", username=" + username + ", name=" + name
                + ", phoneNumber=" + phoneNumber + ", city=" + city + ", createdAt=" + createdAt + ", isActive="
                + isActive + ", menuItems=" + menuItems + "]";
    }
}
