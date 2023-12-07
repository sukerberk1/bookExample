package com.example.jpademo.domain.customer.identities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record CustomerId(@Id UUID id) implements Serializable {
    public CustomerId() {
        this(UUID.randomUUID());
    }
}
