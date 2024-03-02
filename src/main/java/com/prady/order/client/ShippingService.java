package com.prady.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "shipping-service", url = "${SHIPPING_SVC_URL}")
public interface ShippingService {

    @RequestMapping(method = RequestMethod.POST, value = "/shipping")
    ShippingData initiateShipping(ShippingData shippingData);

    @RequestMapping(method = RequestMethod.GET, value = "/shipping/{orderId}", produces = "application/json")
    ShippingData getShippingData(@PathVariable("orderId") Long orderId);
}
