package com.prady.order;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "book_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;


    private String userId;

    private String emailId;

    private String address;

    @Column
    private LocalDateTime orderDate;

    // You can add more order-related attributes here.
    // For example, payment details, shipping information, etc.

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;


}

