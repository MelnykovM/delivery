package com.melnykovm.restapi.delivery.services;

import com.melnykovm.restapi.delivery.repository.UserRepository;
import com.melnykovm.restapi.delivery.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserEntity> getAll() {
        log.info("Get all users");
        return repository.findAll();
    }

    @Override
    public UserEntity get(Long id) {
        log.info("Get user {}", id);
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find user with id " + id));
    }

    @Override
    public UserEntity create(String userName, String phoneNumber, boolean isVIP) {
        UserEntity userEntity = new UserEntity(userName, phoneNumber);
        log.info("Add new user {}", userEntity.getId());

        if (isVIP)
            userEntity.setVIP(true);
        repository.save(userEntity);
        return userEntity;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete user {}", id);
        UserEntity userEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find user with id " + id));
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, String name, String phoneNumber) {
        log.info("Edited user {}", id);
        UserEntity userEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find user with id " + id));
        if (name != null) {
            userEntity.setName(name);
        }
        if (phoneNumber != null) {
            userEntity.setPhoneNumber(phoneNumber);
        }
        repository.save(userEntity);
    }
}
