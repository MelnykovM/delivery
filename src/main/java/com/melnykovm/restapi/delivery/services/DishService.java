package com.melnykovm.restapi.delivery.services;

import com.melnykovm.restapi.delivery.entities.DishEntity;

import java.util.List;

public interface DishService {
    public DishEntity create(String dishName);
    public List<DishEntity> getAll();
    public DishEntity get(Long id);
    public void delete(Long id);
    public void update(Long id, String dishName);
}
