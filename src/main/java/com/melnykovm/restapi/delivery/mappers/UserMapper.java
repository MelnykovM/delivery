package com.melnykovm.restapi.delivery.mappers;

import com.melnykovm.restapi.delivery.models.UserModel;
import com.melnykovm.restapi.delivery.entities.UserEntity;
import com.melnykovm.restapi.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper {

    private final OrderService orderService;

    @Autowired
    public UserMapper(@Lazy OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public UserEntity toEntity(Object model) {
        UserModel userModel = (UserModel) model;
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userModel.getId());
        userEntity.setName(userModel.getName());
        userEntity.setPhoneNumber(userModel.getPhoneNumber());
        userEntity.setVIP(userModel.isVIP());
        userEntity.setOrders(Optional.ofNullable(userModel.getOrdersId())
                .orElse(Collections.emptyList()).stream()
                .map(x -> orderService.get(x))
                .collect(Collectors.toList()));

        return userEntity;
    }

    @Override
    public UserModel toModel(Object entity) {
        UserEntity userEntity = (UserEntity) entity;
        UserModel userModel = new UserModel();

        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setPhoneNumber(userEntity.getPhoneNumber());
        userModel.setVIP(userEntity.isVIP());
        userModel.setOrdersId(Optional.ofNullable(userEntity.getOrders())
                .orElse(Collections.emptyList()).stream()
                .map(x -> x.getId())
                .collect(Collectors.toList()));

        return userModel;
    }
}
