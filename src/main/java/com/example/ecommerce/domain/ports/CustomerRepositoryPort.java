package com.example.ecommerce.domain.ports;

import com.example.ecommerce.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    Customer save(Customer customer);
}
