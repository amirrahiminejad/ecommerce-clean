package com.example.ecommerce.infrastructure.persistence.jpa;

import com.example.ecommerce.domain.model.Customer;
import com.example.ecommerce.domain.ports.CustomerRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long>, CustomerRepositoryPort {
}
