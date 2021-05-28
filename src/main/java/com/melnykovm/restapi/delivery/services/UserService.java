package com.melnykovm.restapi.delivery.services;

import com.melnykovm.restapi.delivery.entities.UserEntity;

import java.util.List;

public interface UserService {
    public UserEntity create(String userName, String phoneNumber, boolean isVIP);
    public List<UserEntity> getAll();
    public UserEntity get(Long id);
    public void update(Long id, String name, String phoneNumber);
    public void delete(Long id);

}
