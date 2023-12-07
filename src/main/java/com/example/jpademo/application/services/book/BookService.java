package com.example.jpademo.application.services.book;

import com.example.jpademo.application.services.book.commands.CreateWithTitleCommand;
import com.example.jpademo.domain.book.Book;

import java.util.Optional;
import java.util.Set;

public interface BookService {
    /**
     * Creates blank book
     * @param command command
     * @see CreateWithTitleCommand
     */
    void createWithTitle(CreateWithTitleCommand command);
}
