package com.melnykovm.restapi.delivery.models;

import java.util.List;

public class UserModel {
    private long id;
    private String name;
    private String phoneNumber;

    private List<Long> ordersId;

    private boolean isVIP;

    public UserModel(long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(List<Long> ordersId) {
        this.ordersId = ordersId;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }
}
