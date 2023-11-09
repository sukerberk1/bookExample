package com.example.jpademo.domain.book.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record ISBN(
        @Column(name = "isbn") String value
) implements Serializable {
    public ISBN()
    {
        this(UUID.randomUUID().toString());
    }
}
