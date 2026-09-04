package com.example.ecommerce.application.dto;

import com.example.ecommerce.domain.model.Order;
import com.example.ecommerce.domain.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(
        Long id,
        Long customerId,
        BigDecimal total,
        String status,
        List<OrderItemResponse> items
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getCustomer().getId(),
                order.calculateTotal(),
                order.getStatus().name(),
                order.getItems().stream()
                        .map(OrderItemResponse::from)
                        .toList()
        );
    }

    public record OrderItemResponse(
            Long productId,
            String productName,
            int quantity,
            BigDecimal unitPrice,
            BigDecimal lineTotal
    ) {
        public static OrderItemResponse from(OrderItem item) {
            return new OrderItemResponse(
                    item.getProduct().getId(),
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    item.getLineTotal()
            );
        }
    }
}
