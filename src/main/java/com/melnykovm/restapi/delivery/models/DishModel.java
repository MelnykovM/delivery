package com.melnykovm.restapi.delivery.models;

import java.util.List;

public class DishModel {
    private long id;
    private String dishName;

    public DishModel(long id, List<Long> ordersId, String dishName) {
        this.id = id;
        this.dishName = dishName;
    }

    public DishModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
