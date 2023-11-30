package com.example.jpademo;

import com.example.jpademo.domain.book.Book;
import com.example.jpademo.domain.book.valueobjects.ISBN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookTest {

    @Test
    void bookIsbnNullTest() {
        Book book = new Book();
        Assertions.assertNull(book.getIsbn());
    }

    @Test
    void bookIsbnNotNullTest() {
        Book book = new Book();
        book.setIsbn(
                new ISBN("Hello!123")
        );
        Assertions.assertNotNull(book.getIsbn());
    }

}
