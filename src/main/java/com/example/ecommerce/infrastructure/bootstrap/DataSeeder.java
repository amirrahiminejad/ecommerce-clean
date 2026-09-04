package com.example.ecommerce.infrastructure.bootstrap;

import com.example.ecommerce.domain.model.Customer;
import com.example.ecommerce.domain.model.Product;
import com.example.ecommerce.infrastructure.persistence.jpa.CustomerJpaRepository;
import com.example.ecommerce.infrastructure.persistence.jpa.ProductJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CustomerJpaRepository customerJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    public DataSeeder(CustomerJpaRepository customerJpaRepository,
                      ProductJpaRepository productJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public void run(String... args) {
        if (customerJpaRepository.count() == 0) {
            customerJpaRepository.save(new Customer("Ali Rahimi", "ali@example.com"));
            customerJpaRepository.save(new Customer("Sara Ahmadi", "sara@example.com"));
        }

        if (productJpaRepository.count() == 0) {
            productJpaRepository.save(new Product("Laptop Pro", "15-inch lightweight laptop", new BigDecimal("25000000"), 10));
            productJpaRepository.save(new Product("Wireless Mouse", "Ergonomic mouse", new BigDecimal("450000"), 25));
            productJpaRepository.save(new Product("Mechanical Keyboard", "RGB keyboard", new BigDecimal("900000"), 15));
        }
    }
}
