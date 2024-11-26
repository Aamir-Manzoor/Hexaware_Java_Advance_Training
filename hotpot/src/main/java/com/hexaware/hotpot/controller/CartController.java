//package com.hexaware.hotpot.controller;
//
//import com.hexaware.hotpot.models.Cart;
//import com.hexaware.hotpot.service.ICartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/carts")
//public class CartController {
//    
//    @Autowired
//    private ICartService cartService;
//    
//    @PostMapping
//    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
//        return ResponseEntity.ok(cartService.createCart(cart));
//    }
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
//        return cartService.getCartById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Cart>> getCartsByUser(@PathVariable Long userId) {
//        return ResponseEntity.ok(cartService.getCartsByUser(userId));
//    }
//    
//    @GetMapping("/user/{userId}/restaurant/{restaurantId}")
//    public ResponseEntity<Cart> getCartByUserAndRestaurant(
//            @PathVariable Long userId,
//            @PathVariable Long restaurantId) {
//        return cartService.getCartByUserAndRestaurant(userId, restaurantId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
//        cart.setCartId(id);
//        return ResponseEntity.ok(cartService.updateCart(cart));
//    }
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
//        cartService.deleteCart(id);
//        return ResponseEntity.ok().build();
//    }
//    
//    @PostMapping("/{id}/clear")
//    public ResponseEntity<Void> clearCart(@PathVariable Long id) {
//        cartService.clearCart(id);
//        return ResponseEntity.ok().build();
//    }
//}