package com.prady.order;

import com.prady.order.client.BookStock;
import com.prady.order.client.InventoryService;
import com.prady.order.client.ShippingData;
import com.prady.order.client.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.core.log.LogMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/v1")
public class OrderController {



    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/orders")
    public ResponseEntity<Long> placeOrder(@RequestBody Order order) {
        order.setOrderDate(LocalDateTime.now());
        updateStockData(order);
        Order orderCreated = orderRepository.save(order);
        initiateShipping(orderCreated);
        return ResponseEntity.ok(orderCreated.getOrderId());
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<ViewOrder> viewOrder(@PathVariable Long orderId) {
        ViewOrder viewOrder = new ViewOrder();

        Order order = orderRepository.findById(orderId).orElse(null);
        viewOrder.setOrder(order);
         viewOrder.setShippingData(
                 shippingService.getShippingData(order.getOrderId()));
        return ResponseEntity.ok(viewOrder);
    }

    private void initiateShipping(Order orderCreated) {
        ShippingData shippingData = new ShippingData();
        shippingData.setOrderId(orderCreated.getOrderId());
        shippingData.setEmailId(orderCreated.getEmailId());
        shippingData.setAddress(orderCreated.getAddress());
        streamBridge.send("ship-order", shippingData);
        //shippingService.initiateShipping(shippingData);
    }

    private void updateStockData(Order order) {
        var orderItems =  order.getOrderItems();
        for (OrderItem orderItem:orderItems) {
             BookStock bookStock =
                     inventoryService.getStock(orderItem.getBookId());
            int availableQuantity =
                    bookStock.getAvailableQuantity() - orderItem.getQuantity();
            bookStock.setAvailableQuantity(availableQuantity);
            inventoryService.updateStock(bookStock);
            //streamBridge.send("update-stock", bookStock);
        }
    }

}
