package com.example.jpademo.persistence;

import com.example.jpademo.domain.customer.Customer;
import com.example.jpademo.domain.customer.identities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
