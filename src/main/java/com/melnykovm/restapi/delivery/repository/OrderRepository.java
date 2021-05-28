package com.melnykovm.restapi.delivery.repository;

import com.melnykovm.restapi.delivery.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
