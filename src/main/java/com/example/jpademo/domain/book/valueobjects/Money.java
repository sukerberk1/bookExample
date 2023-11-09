package com.example.jpademo.domain.book.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Embeddable
public record Money(
        BigDecimal amount,
        String currency_code) implements Serializable {
    public Money()
    {
        this(BigDecimal.ZERO, "PLN");
    }
}
