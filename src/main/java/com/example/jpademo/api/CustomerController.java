package com.example.jpademo.api;

import com.example.jpademo.application.services.customer.CustomerService;
import com.example.jpademo.application.services.customer.commands.CreateCustomerWithNameCommand;
import com.example.jpademo.application.utils.nullableproperty.NullableProperty;
import com.example.jpademo.domain.customer.Customer;
import com.example.jpademo.domain.customer.identities.CustomerId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Set<Customer>> getAllCustomers()
    {
        var customers = customerService.retrieveAll();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<CustomerId> createCustomerWithName(@RequestBody CreateCustomerWithNameCommand command)
    {
        var createdCustomerId = customerService.createCustomerWithName(command);
        return ResponseEntity.ok(createdCustomerId);
    }


}
