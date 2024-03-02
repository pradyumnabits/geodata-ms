package com.prady.order.client;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Component
public class ShippingData {


    private Long shippingId;


    @NotNull
    private Long orderId;

    private String emailId;

    private String address;

    private  ShippingStatus shippingStatus;
}

