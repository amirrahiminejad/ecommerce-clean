package com.example.ecommerce.domain.ports;

import com.example.ecommerce.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product save(Product product);
}
