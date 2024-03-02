package com.prady.order;

import com.prady.order.client.BookStock;
import com.prady.order.client.ShippingData;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViewOrder {

    private Order order;

    private ShippingData shippingData;

}
