package com.example.ecommerce.application.service;

import com.example.ecommerce.domain.model.Customer;
import com.example.ecommerce.domain.ports.CustomerRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepositoryPort customerRepositoryPort;

    public CustomerService(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    public List<Customer> getAllCustomers() {
        return customerRepositoryPort.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }
}
