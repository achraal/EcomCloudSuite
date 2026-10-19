package com.achraf.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
