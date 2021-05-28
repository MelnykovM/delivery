package com.melnykovm.restapi.delivery.services;

import com.melnykovm.restapi.delivery.entities.OrderEntity;

import java.util.List;

public interface OrderService {
    public List<OrderEntity> getAll();
    public OrderEntity get(Long id);
    public OrderEntity create(Long id, String address, Integer amount, List<Long> dishes);
    public void delete(Long id);
    public void update(Long id, String address, Integer amount, List<Long> dishes);

    //public OrderModel orderEntityToModel(OrderEntity orderEntity);
}
