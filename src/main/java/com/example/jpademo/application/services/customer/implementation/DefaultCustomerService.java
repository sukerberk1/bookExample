package com.example.jpademo.application.services.customer.implementation;

import com.example.jpademo.application.services.customer.CustomerService;
import com.example.jpademo.application.services.customer.commands.CreateCustomerWithNameCommand;
import com.example.jpademo.application.services.customer.commands.LendBookCommand;
import com.example.jpademo.domain.book.Book;
import com.example.jpademo.domain.customer.Customer;
import com.example.jpademo.domain.customer.identities.CustomerId;
import com.example.jpademo.persistence.BookRepository;
import com.example.jpademo.persistence.CustomerRepository;

import java.util.Optional;

public class DefaultCustomerService implements CustomerService {

    CustomerRepository customerRepository;
    BookRepository bookRepository;

    public DefaultCustomerService(CustomerRepository customerRepository, BookRepository bookRepository)
    {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public CustomerId createCustomerWithName(CreateCustomerWithNameCommand command) {
        Customer newCustomer = new Customer();
        newCustomer.setName(command.firstName);
        newCustomer.setSurname(command.lastName);
        var savedCustomer = customerRepository.save(newCustomer);
        return savedCustomer.getId();
    }

    @Override
    public boolean lendBookOfISBN(LendBookCommand command) {
        Optional<Customer> lender = customerRepository.findById(command.customerId);
        Optional<Book> bookToBorrow = bookRepository.findById(command.isbn);
        if (lender.isEmpty() || bookToBorrow.isEmpty())
            return false;
        var lenderEntity = lender.get();
        var bookEntity = bookToBorrow.get();

        var borrowedBooks = lenderEntity.getBorrowedBooks();
        borrowedBooks.add(bookEntity);

        lenderEntity.setBorrowedBooks(borrowedBooks);

        customerRepository.save(lenderEntity);

        return true;
    }
}
