package com.bank.customerservice.controller;

import com.bank.customerservice.entity.Customer;

import com.bank.customerservice.service.CustomerService;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/customers")

public class CustomerController {

    private final CustomerService service;

    public CustomerController(
            CustomerService service) {

        this.service = service;
    }

    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer) {

        return service.create(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable Long id) {

        return service.get(id);
    }
}
