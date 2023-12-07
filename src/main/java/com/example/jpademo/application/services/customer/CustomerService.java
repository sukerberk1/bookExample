package com.example.jpademo.application.services.customer;

import com.example.jpademo.application.services.customer.commands.CreateCustomerWithNameCommand;
import com.example.jpademo.application.services.customer.commands.LendBookCommand;
import com.example.jpademo.domain.customer.identities.CustomerId;

public interface CustomerService {
    CustomerId createCustomerWithName(CreateCustomerWithNameCommand command);
    boolean lendBookOfISBN(LendBookCommand command);
}
