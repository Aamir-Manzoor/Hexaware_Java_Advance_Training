package com.hexaware.hotpot.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(length = 15)
    private String phoneNumber;
    
    @Column(nullable = false, length = 50)
    private String city;
    
    @Column
    private LocalDateTime createdAt;
    
    @Column
    private Boolean isActive = true;
    
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems = new ArrayList<>();
    
    // Getters
    public Long getRestaurantId() {
        return restaurantId;
    }
    public User getUser() {
        return user;
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
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    
    // Setters
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public void setUser(User user) {
        this.user = user;
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
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    
    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", createdAt=" + createdAt +
                ", isActive=" + isActive +
                '}';
    }
}