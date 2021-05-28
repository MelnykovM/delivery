package com.melnykovm.restapi.delivery.repository;

import com.melnykovm.restapi.delivery.entities.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
}
