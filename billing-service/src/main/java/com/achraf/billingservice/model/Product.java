package com.achraf.billingservice.model;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
