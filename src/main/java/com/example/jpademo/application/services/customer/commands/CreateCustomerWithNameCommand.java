package com.example.jpademo.application.services.customer.commands;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerWithNameCommand {
    public String firstName;
    public String lastName;
}
