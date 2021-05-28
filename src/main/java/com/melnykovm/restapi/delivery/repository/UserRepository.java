package com.melnykovm.restapi.delivery.repository;

import com.melnykovm.restapi.delivery.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
