package com.achraf.billingservice.feign;

import com.achraf.billingservice.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/api/products/{id}")
    @CircuitBreaker(name = "inventory", fallbackMethod = "getDefaultProduct")
    Product getProduct(@PathVariable String id);

    default Product getDefaultProduct(String id, Exception e) {
//        return new Product(id, null, 0.0, 0);
        return Product.builder()
                .id(id)
//                .name("fallback-name")
//                .price(0.0)
                .build();
    }
}
