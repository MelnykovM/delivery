package com.melnykovm.restapi.delivery.models;

import java.time.LocalDateTime;
import java.util.List;

public class OrderModel {

    private long id;

    private LocalDateTime date;
    private String address;
    private int amount;

    private List<DishModel> dishes;

    private long usersId;

    public OrderModel(long id, LocalDateTime date, String address, int amount) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.amount = amount;
    }

    public OrderModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<DishModel> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishModel> dishes) {
        this.dishes = dishes;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }
}
