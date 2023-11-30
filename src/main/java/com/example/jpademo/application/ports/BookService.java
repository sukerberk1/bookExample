package com.example.jpademo.application.ports;

import com.example.jpademo.domain.book.Book;

import java.util.Optional;
import java.util.Set;

public interface BookService {
    Optional<Book> getBookByISBN(String isbnText);
    Set<Book> getAllBooks();
    Book createBook(Book book);
}
