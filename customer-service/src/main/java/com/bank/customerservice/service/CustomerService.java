package com.bank.customerservice.service;

import com.bank.customerservice.entity.Customer;
import com.bank.customerservice.repository.CustomerRepository;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(
            CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(
            Customer customer) {

        return repository.save(customer);
    }

    public Customer get(Long id) {

        return repository
                .findById(id)
                .orElse(null);
    }
}
