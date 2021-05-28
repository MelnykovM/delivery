package com.melnykovm.restapi.delivery.mappers;

import com.melnykovm.restapi.delivery.entities.OrderEntity;
import com.melnykovm.restapi.delivery.models.OrderModel;
import com.melnykovm.restapi.delivery.services.DishService;
import com.melnykovm.restapi.delivery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements Mapper {

    private final UserService userService;
    private final DishService dishService;
    private final UserMapper userMapper;
    private final DishMapper dishMapper;


    @Autowired
    public OrderMapper(@Lazy DishService dishService,@Lazy UserService userService, @Lazy UserMapper userMapper, @Lazy DishMapper dishMapper) {
        this.dishService = dishService;
        this.userService = userService;

        this.userMapper = userMapper;
        this.dishMapper = dishMapper;

    }

    @Override
    public OrderEntity toEntity(Object model) {
        OrderModel orderModel = (OrderModel) model;
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId(orderModel.getId());
        orderEntity.setDate(orderModel.getDate());
        orderEntity.setAddress(orderModel.getAddress());
        orderEntity.setAmount(orderModel.getAmount());
        orderEntity.setDishes(Optional.ofNullable(orderModel.getDishes())
                .orElse(Collections.emptyList()).stream()
                .map(x -> dishMapper.toEntity(x))
                .collect(Collectors.toList()));

        orderEntity.setUser(userService.get(orderModel.getUsersId()));

        return orderEntity;
    }

    @Override
    public OrderModel toModel(Object entity) {
        OrderEntity orderEntity = (OrderEntity) entity;
        OrderModel orderModel = new OrderModel();

        orderModel.setId(orderEntity.getId());
        orderModel.setDate(orderEntity.getDate());
        orderModel.setAddress(orderEntity.getAddress());
        orderModel.setAmount(orderEntity.getAmount());
        orderModel.setDishes(Optional.ofNullable(orderEntity.getDishes())
                .orElse(Collections.emptyList()).stream()
                .map(x -> dishMapper.toModel(x))
                .collect(Collectors.toList()));

        orderModel.setUsersId(orderEntity.getUser().getId());

        return orderModel;
    }
}
