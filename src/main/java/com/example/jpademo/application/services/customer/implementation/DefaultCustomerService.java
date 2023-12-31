package com.example.jpademo.application.services.customer.implementation;

import com.example.jpademo.application.services.customer.CustomerService;
import com.example.jpademo.application.services.customer.commands.CreateCustomerWithNameCommand;
import com.example.jpademo.application.services.customer.commands.LendBookCommand;
import com.example.jpademo.domain.book.Book;
import com.example.jpademo.domain.customer.Customer;
import com.example.jpademo.domain.customer.identities.CustomerId;
import com.example.jpademo.persistence.BookRepository;
import com.example.jpademo.persistence.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
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
        lenderEntity.addBorrowedBook(bookEntity);
        customerRepository.save(lenderEntity);

        return true;
    }

    @Override
    public Set<Customer> retrieveAll() {
        return new HashSet<>(customerRepository.findAll());
    }

    @Override
    public Customer createRandomCustomerWithName(String name) {
        Customer customer = new Customer();
        customer.setId(new CustomerId());
        customer.setName(name);
        String[] randomSurnames = new String[]{
                "Sukerberg", "Makurembergier", "Rurkenberg",
                "Gutenberg", "Niggerbergson", "Burger"
        };
        Random randomChoice = new Random();
        customer.setSurname(randomSurnames[randomChoice.nextInt(randomSurnames.length)]);

        customerRepository.save(customer);

        return customer;
    }
}
