//package com.hexaware.hotpot.controller;
//
//import com.hexaware.hotpot.models.OrderItem;
//import com.hexaware.hotpot.service.IOrderItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/order-items")
//public class OrderItemController {
//    
//    @Autowired
//    private IOrderItemService orderItemService;
//    
//    @PostMapping
//    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
//        return ResponseEntity.ok(orderItemService.createOrderItem(orderItem));
//    }
//    
//    @PostMapping("/batch")
//    public ResponseEntity<List<OrderItem>> createOrderItems(@RequestBody List<OrderItem> orderItems) {
//        return ResponseEntity.ok(orderItemService.createOrderItems(orderItems));
//    }
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<OrderItem> getOrderItem(@PathVariable Long id) {
//        return orderItemService.getOrderItemById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
//    @GetMapping("/order/{orderId}")
//    public ResponseEntity<List<OrderItem>> getOrderItemsByOrder(@PathVariable Long orderId) {
//        return ResponseEntity.ok(orderItemService.getOrderItemsByOrder(orderId));
//    }
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<OrderItem> updateOrderItem(
//            @PathVariable Long id,
//            @RequestBody OrderItem orderItem) {
//        orderItem.setOrderItemId(id);
//        return ResponseEntity.ok(orderItemService.updateOrderItem(orderItem));
//    }
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
//        orderItemService.deleteOrderItem(id);
//        return ResponseEntity.ok().build();
//    }
//}