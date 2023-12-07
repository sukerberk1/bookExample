package com.example.jpademo.domain.book;

import com.example.jpademo.domain.book.valueobjects.ISBN;
import com.example.jpademo.domain.book.valueobjects.Money;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Book {
    @Id
    private ISBN isbn = new ISBN();

    private String title;

    @Embedded
    private Money price;

    @Nullable
    LocalDate publicationDate = null;
}
