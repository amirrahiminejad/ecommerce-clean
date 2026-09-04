package com.example.ecommerce.infrastructure.persistence.jpa;

import com.example.ecommerce.domain.model.Product;
import com.example.ecommerce.domain.ports.ProductRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long>, ProductRepositoryPort {
}
