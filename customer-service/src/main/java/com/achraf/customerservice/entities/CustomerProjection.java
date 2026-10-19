package com.achraf.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customerProjection", types = Customer.class)
public interface CustomerProjection {
    String getName();
    String getEmail();
}
