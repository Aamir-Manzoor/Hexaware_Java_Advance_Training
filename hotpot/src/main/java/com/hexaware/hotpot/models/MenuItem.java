package com.hexaware.hotpot.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "MenuItems")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuItemId;
    
    @ManyToOne
    @JoinColumn(name = "RestaurantID")
    private Restaurant restaurant;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(length = 50)
    private String category;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column
    private Boolean isAvailable = true;

    // Getters
    public Long getMenuItemId() {
        return menuItemId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    // Setters
    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemId=" + menuItemId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MenuItem menuItem = (MenuItem) o;
//        return Objects.equals(menuItemId, menuItem.menuItemId) &&
//                Objects.equals(name, menuItem.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(menuItemId, name);
//    }
}
