package com.example.jpademo.domain.customer;

import com.example.jpademo.domain.book.Book;
import com.example.jpademo.domain.customer.identities.CustomerId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashMap;
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
    Set<Book> borrowedBooks;

}
