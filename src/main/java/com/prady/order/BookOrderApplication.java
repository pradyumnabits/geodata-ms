package com.prady.order;

import com.prady.order.client.ShippingData;
import com.prady.order.client.ShippingStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication(scanBasePackages = "com.prady.order")
@EnableFeignClients
public class BookOrderApplication {
//    private static final Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(BookOrderApplication.class, args);
    }

//    @Bean
//    public Supplier<ShippingData> shippingDataProducer() {
//
//        return () ->
//        {
//            ShippingData shippingData = new ShippingData();
//
//            return shippingData;
//        };
//    }
//
//    public static ShippingData generateRandomShippingData() {
//        ShippingData shippingData = new ShippingData();
//
//        shippingData.setShippingId(random.nextLong());
//        shippingData.setOrderId(random.nextLong());
//        shippingData.setEmailId(generateRandomEmail());
//        shippingData.setAddress(generateRandomAddress());
//        shippingData.setShippingStatus(ShippingStatus.values()[random.nextInt(ShippingStatus.values().length)]);
//
//        return shippingData;
//    }
//
//    private static String generateRandomEmail() {
//        // Generate a random email address using a UUID
//        return UUID.randomUUID().toString() + "@example.com";
//    }
//
//    private static String generateRandomAddress() {
//        // Generate a random address (for simplicity, using a placeholder)
//        return "123 Main St, Anytown, USA";
//    }

}
