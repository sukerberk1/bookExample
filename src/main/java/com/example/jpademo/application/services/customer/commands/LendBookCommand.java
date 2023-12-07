package com.example.jpademo.application.services.customer.commands;

import com.example.jpademo.domain.book.valueobjects.ISBN;
import com.example.jpademo.domain.customer.identities.CustomerId;

public class LendBookCommand {
    public ISBN isbn;
    public CustomerId customerId;
}
