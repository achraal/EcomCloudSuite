package com.achraf.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customerProjectionEmail", types = Customer.class)
public interface CustomerProjectionEmail {
    String getEmail();
}
