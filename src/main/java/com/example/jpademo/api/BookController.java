package com.example.jpademo.api;

import com.example.jpademo.application.ports.BookService;
import com.example.jpademo.domain.book.Book;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/books")
public final class BookController {
    BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping
    public Set<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Optional<Book> getBookByIsbn(@PathVariable  String isbn)
    {
        return bookService.getBookByISBN(isbn);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book)
    {
        return bookService.createBook(book);
    }

}
