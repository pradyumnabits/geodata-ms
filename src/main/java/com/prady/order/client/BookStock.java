package com.prady.order.client;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookStock {

    private Long bookId;

    @NotNull
    private String bookName;

    private String bookDescription;


    private int availableQuantity;

    private double price;

}
