package com.example.SpringPassoAPasso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPassoAPasso.entities.OrderItem;
import com.example.SpringPassoAPasso.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
