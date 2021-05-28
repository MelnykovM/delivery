package com.melnykovm.restapi.delivery.services;

import com.melnykovm.restapi.delivery.repository.DishRepository;
import com.melnykovm.restapi.delivery.entities.DishEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final DishRepository repository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DishEntity> getAll() {
        log.info("Get all dishes");
        return repository.findAll();
    }

    @Override
    public DishEntity get(Long id) {
        log.info("Get {} dish", id);
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find dish " + id.toString()));
    }

    @Override
    public DishEntity create(String dishName) {
        log.info("New dish entity {}", dishName);
        try {
            DishEntity dishEntity = new DishEntity(dishName);
            repository.save(dishEntity);
            return dishEntity;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        log.info("Delete dish {}", id);
        DishEntity dishEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find dish " + id.toString()));
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, String dishName) {
        log.info("Edited dish {}", id);
        DishEntity dishEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find dish " + id.toString()));
        if (dishName != null) {
            try {
                dishEntity.setDishName(dishName);
            } catch (Exception e) {
                log.error(e.getLocalizedMessage());
            }
        }
        repository.save(dishEntity);
    }
}
