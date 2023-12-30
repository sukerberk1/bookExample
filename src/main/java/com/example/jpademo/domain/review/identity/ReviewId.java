package com.example.jpademo.domain.review.identity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record ReviewId(UUID id) implements Serializable {
    public ReviewId() {
        this(UUID.randomUUID());
    }

    public static ReviewId fromString(String value) {
        return new ReviewId(UUID.fromString(value));
    }
}
