package com.achraf.billingservice;

import com.achraf.billingservice.entities.Bill;
import com.achraf.billingservice.entities.ProductItem;
import com.achraf.billingservice.repository.BillRepository;
import com.achraf.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository
    ){
        return args -> {
            List<Long> customersIds = List.of(1L, 2L, 3L);
            List<String> productsIds = List.of(
                    "c0a03b76-50eb-43b1-9a52-2a8d8226f935",
                    "eb6fa311-57d2-4bab-9572-f79628c2a4f2",
                    "955956fd-c2cd-4d6a-af0d-2eee4e1e9083");
            customersIds.forEach(clientId -> {
                Bill bill = new Bill();
                bill.setCustomerId(clientId);
                bill.setBillingDate(new Date());
                billRepository.save(bill);
                productsIds.forEach(productId -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setQuantity(new Random().nextInt(20));
                    productItem.setPrice(1000 * Math.random() * 600);
                    productItem.setProductId(productId);
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
