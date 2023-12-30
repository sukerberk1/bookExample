package com.example.jpademo.domain.customer;

import com.example.jpademo.domain.book.Book;
import com.example.jpademo.domain.book.valueobjects.ISBN;
import com.example.jpademo.domain.customer.identities.CustomerId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer is library's client
 */
@Data
@Entity
public class Customer{
    @EmbeddedId
    private CustomerId id;
    private String name;
    private String surname;
    @OneToMany
    final Set<Book> borrowedBooks = new HashSet<>();

    public void addBorrowedBook(Book book)
    {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(ISBN isbn)
    {
        var book = borrowedBooks.stream().filter(o->o.getIsbn().equals(isbn)).findFirst();
        book.ifPresent(borrowedBooks::remove);
    }
}
