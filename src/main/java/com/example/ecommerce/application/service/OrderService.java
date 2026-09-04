package com.example.ecommerce.application.service;

import com.example.ecommerce.application.dto.CreateOrderRequest;
import com.example.ecommerce.application.dto.OrderItemRequest;
import com.example.ecommerce.application.dto.OrderResponse;
import com.example.ecommerce.domain.model.Customer;
import com.example.ecommerce.domain.model.Order;
import com.example.ecommerce.domain.model.OrderItem;
import com.example.ecommerce.domain.model.Product;
import com.example.ecommerce.domain.ports.CustomerRepositoryPort;
import com.example.ecommerce.domain.ports.OrderRepositoryPort;
import com.example.ecommerce.domain.ports.ProductRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final CustomerRepositoryPort customerRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final OrderRepositoryPort orderRepositoryPort;

    public OrderService(CustomerRepositoryPort customerRepositoryPort,
                        ProductRepositoryPort productRepositoryPort,
                        OrderRepositoryPort orderRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {
        Customer customer = customerRepositoryPort.findById(request.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + request.customerId()));

        if (request.items() == null || request.items().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item.");
        }

        Order order = new Order(customer);

        for (OrderItemRequest itemRequest : request.items()) {
            Product product = productRepositoryPort.findById(itemRequest.productId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + itemRequest.productId()));

            if (itemRequest.quantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero for product: " + product.getName());
            }

            product.reduceStock(itemRequest.quantity());
            OrderItem orderItem = new OrderItem(product, itemRequest.quantity());
            order.addItem(orderItem);
        }

        Order saved = orderRepositoryPort.save(order);
        return OrderResponse.from(saved);
    }

    public List<OrderResponse> getAllOrders() {
        return new ArrayList<>();
    }
}
