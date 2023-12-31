package com.example.jpademo.application.services.book.implementation;

import com.example.jpademo.application.services.book.BookService;
import com.example.jpademo.application.services.book.commands.CreateWithTitleCommand;
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

    /**
     * Creates blank book
     *
     * @param command command
     * @see CreateWithTitleCommand
     */
    @Override
    public void createWithTitle(CreateWithTitleCommand command) {
        Book newBook = new Book();
        newBook.setIsbn(new ISBN());
        newBook.setTitle(command.getTitle());
        bookRepository.save(newBook);
    }

    @Override
    public Set<Book> retrieveAllBooks() {
        return new HashSet<>(bookRepository.findAll());
    }


}
