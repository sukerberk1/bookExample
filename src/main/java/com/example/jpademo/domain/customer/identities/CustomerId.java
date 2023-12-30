package com.example.jpademo.domain.customer.identities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record CustomerId(UUID id) implements Serializable {
    public CustomerId() {
        this(UUID.randomUUID());
    }
    public static CustomerId fromString(String string)
    {
        return new CustomerId(UUID.fromString(string));
    }
}
