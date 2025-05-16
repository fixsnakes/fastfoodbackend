package com.example.custom_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.custom_manager.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o " +
            "JOIN FETCH o.customer " +
            "LEFT JOIN FETCH o.voucher " +  // Sử dụng LEFT JOIN FETCH để voucher có thể là null
            "JOIN FETCH o.orderDetails od " +
            "JOIN FETCH od.product " +
            "WHERE o.order_id = :orderId")
    Order findOrderWithDetails(@Param("orderId") Long orderId);
}
