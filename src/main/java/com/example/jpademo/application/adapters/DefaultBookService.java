package com.example.jpademo.application.adapters;

import com.example.jpademo.application.ports.BookService;
import com.example.jpademo.domain.book.Book;
import com.example.jpademo.domain.book.valueobjects.ISBN;
import com.example.jpademo.persistence.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DefaultBookService implements BookService {

    BookRepository bookRepository;

    public DefaultBookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBookByISBN(String isbnText) {
        var book =  bookRepository.findById(
                new ISBN(isbnText)
        );
        return book;
    }

    @Override
    public Set<Book> getAllBooks() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
