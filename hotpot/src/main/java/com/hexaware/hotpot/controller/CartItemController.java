//package com.hexaware.hotpot.controller;
//
//import com.hexaware.hotpot.models.CartItem;
//import com.hexaware.hotpot.service.ICartItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/cart-items")
//public class CartItemController {
//
//    @Autowired
//    private ICartItemService cartItemService;
//
//    @PostMapping
//    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
//        CartItem newCartItem = cartItemService.addCartItem(cartItem);
//        return new ResponseEntity<>(newCartItem, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
//        return cartItemService.getCartItemById(id)
//                .map(cartItem -> new ResponseEntity<>(cartItem, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping("/cart/{cartId}")
//    public ResponseEntity<List<CartItem>> getCartItemsByCart(@PathVariable Long cartId) {
//        List<CartItem> cartItems = cartItemService.getCartItemsByCart(cartId);
//        return new ResponseEntity<>(cartItems, HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItem) {
//        cartItem.setCartItemId(id);
//        try {
//            CartItem updatedCartItem = cartItemService.updateCartItem(cartItem);
//            return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
//        cartItemService.deleteCartItem(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PatchMapping("/{id}/quantity")
//    public ResponseEntity<CartItem> updateQuantity(@PathVariable Long id, @RequestParam int quantity) {
//        try {
//            CartItem updatedCartItem = cartItemService.updateQuantity(id, quantity);
//            return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PatchMapping("/{id}/instructions")
//    public ResponseEntity<CartItem> updateSpecialInstructions(
//            @PathVariable Long id, 
//            @RequestParam String instructions) {
//        try {
//            CartItem updatedCartItem = cartItemService.updateSpecialInstructions(id, instructions);
//            return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}