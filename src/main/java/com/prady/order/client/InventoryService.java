package com.prady.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "inventory-service", url = "${INVENTORY_SVC_URL}")
public interface InventoryService {

    @RequestMapping(method = RequestMethod.PUT, value = "/stocks")
    BookStock updateStock(@RequestBody BookStock bookStock);
    @RequestMapping(method = RequestMethod.GET, value = "/stocks")
    List<BookStock> getAllStocks();
    @RequestMapping(method = RequestMethod.GET, value = "/stocks/{bookId}", produces = "application/json")
    BookStock getStock(@PathVariable("bookId") Long bookId);
}
