package com.example.ecommerce.domain.ports;

import com.example.ecommerce.domain.model.Order;

import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);

    Optional<Order> findById(Long id);
}
