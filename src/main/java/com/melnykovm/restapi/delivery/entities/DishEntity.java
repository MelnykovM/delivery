package com.melnykovm.restapi.delivery.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "dishes")
    private List<OrderEntity> orders = new ArrayList<>();

    private String dishName;

    public DishEntity(Long id, String dishName) {
        this.id = id;
        this.dishName = dishName;
    }

    public DishEntity(String dishName) {
        this.dishName = dishName;
    }

    public DishEntity() {
    }

    public DishEntity(String dishName, List<OrderEntity> orders) {
        this.dishName = dishName;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
