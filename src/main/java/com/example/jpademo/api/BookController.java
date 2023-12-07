package com.example.jpademo.api;

import com.example.jpademo.application.services.book.BookService;
import com.example.jpademo.domain.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/books")
public final class BookController {
    BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }


}
