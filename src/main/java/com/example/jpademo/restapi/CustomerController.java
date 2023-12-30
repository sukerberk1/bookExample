package com.example.jpademo.restapi;

import com.example.jpademo.application.services.customer.CustomerService;
import com.example.jpademo.domain.customer.Customer;
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

    @PostMapping
    public ResponseEntity<Customer> createRandomCustomer(@RequestBody String name)
    {
        var result = customerService.createRandomCustomerWithName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<Set<Customer>> retrieveAllCustomers()
    {
        var customers = customerService.retrieveAll();
        return ResponseEntity.ok(customers);
    }
}
