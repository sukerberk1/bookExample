package com.example.jpademo.domain.book;

import com.example.jpademo.domain.book.valueobjects.ISBN;
import com.example.jpademo.domain.book.valueobjects.Money;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Book {
    @Id
    private ISBN isbn;

    private String title;

    @Embedded
    private Money price;
}
