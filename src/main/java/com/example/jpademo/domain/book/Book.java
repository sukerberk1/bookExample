package com.example.jpademo.domain.book;

import com.example.jpademo.domain.book.valueobjects.ISBN;
import com.example.jpademo.domain.book.valueobjects.Money;
import com.example.jpademo.domain.customer.Customer;
import com.example.jpademo.domain.review.Review;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class Book {
    @Id
    private ISBN isbn = new ISBN();

    private String title;

    @Embedded
    private Money price;

    @Nullable
    private LocalDate publicationDate = null;
    @ManyToMany
    private Map<Customer, Review> customerReviewMap = new HashMap<>();
}
