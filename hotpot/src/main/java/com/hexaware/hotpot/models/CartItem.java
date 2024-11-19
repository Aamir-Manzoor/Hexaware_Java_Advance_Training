package com.hexaware.hotpot.models;

import jakarta.persistence.*;


@Entity
@Table(name = "CartItems",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"CartID", "MenuItemID"})})
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    
    @ManyToOne
    @JoinColumn(name = "CartID", nullable = false)
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name = "MenuItemID", nullable = false)
    private MenuItem menuItem;
    
    @Column(nullable = false)
    private Integer quantity = 1;
    
    @Column
    private String specialInstructions;

    // Getters
    public Long getCartItemId() {
        return cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    // Setters
    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // Helper methods
    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
        }
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", menuItem=" + (menuItem != null ? menuItem.getName() : "null") +
                ", quantity=" + quantity +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CartItem cartItem = (CartItem) o;
//        return Objects.equals(cartItemId, cartItem.cartItemId) &&
//               Objects.equals(cart, cartItem.cart) &&
//               Objects.equals(menuItem, cartItem.menuItem);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(cartItemId, cart, menuItem);
//    }
}



