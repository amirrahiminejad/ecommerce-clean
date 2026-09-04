package com.example.ecommerce.infrastructure.persistence.jpa;

import com.example.ecommerce.domain.model.Order;
import com.example.ecommerce.domain.ports.OrderRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Long>, OrderRepositoryPort {
}
