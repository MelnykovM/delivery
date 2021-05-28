package com.melnykovm.restapi.delivery.mappers;

import com.melnykovm.restapi.delivery.models.DishModel;
import com.melnykovm.restapi.delivery.entities.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishMapper implements Mapper {

    @Autowired
    public DishMapper() {
    }

    @Override
    public DishEntity toEntity(Object model) {
        DishModel dishModel = (DishModel) model;
        DishEntity dishEntity = new DishEntity();

        dishEntity.setId(dishModel.getId());
        dishEntity.setDishName(dishModel.getDishName());
        return dishEntity;
    }

    @Override
    public DishModel toModel(Object entity) {
        DishEntity dishEntity = (DishEntity) entity;
        DishModel dishModel = new DishModel();

        dishModel.setId(dishEntity.getId());
        dishModel.setDishName(dishEntity.getDishName());

        return dishModel;
    }
}
