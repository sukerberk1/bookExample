package com.example.jpademo.application.services.customer;

import com.example.jpademo.application.services.customer.commands.CreateCustomerWithNameCommand;
import com.example.jpademo.application.services.customer.commands.LendBookCommand;
import com.example.jpademo.domain.customer.Customer;
import com.example.jpademo.domain.customer.identities.CustomerId;

import java.util.Set;

public interface CustomerService {
    CustomerId createCustomerWithName(CreateCustomerWithNameCommand command);
    boolean lendBookOfISBN(LendBookCommand command);

    Set<Customer> retrieveAll();
}
