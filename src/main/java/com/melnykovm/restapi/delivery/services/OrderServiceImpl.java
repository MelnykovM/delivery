package com.melnykovm.restapi.delivery.services;

import com.melnykovm.restapi.delivery.entities.DishEntity;
import com.melnykovm.restapi.delivery.entities.OrderEntity;
import com.melnykovm.restapi.delivery.entities.UserEntity;
import com.melnykovm.restapi.delivery.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final OrderRepository repository;

    private final UserService userService;
    private final DishService dishService;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, @Lazy UserService userService, @Lazy DishService dishService) {
        this.repository = repository;
        this.userService = userService;
        this.dishService = dishService;
    }

    @Override
    public List<OrderEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public OrderEntity get(Long id) {
        log.info("Get {} order", id);
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find order" + id));
    }

    @Override
    public OrderEntity create(Long userId, String address, Integer amount, List<Long> dishes) {

        UserEntity userEntity = userService.get(userId);
        OrderEntity orderEntity = new OrderEntity(address, amount, userEntity);

        log.info("New order {}", orderEntity.getId());

        List<DishEntity> listOfDishEntity = Optional.ofNullable(dishes)
                .orElse(Collections.emptyList()).stream()
                .map(x -> dishService.get(x))
                .collect(Collectors.toList());
        orderEntity.setDishes(listOfDishEntity);
        repository.save(orderEntity);

        return orderEntity;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete order {}", id);
        OrderEntity orderEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find order" + id));
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, String address, Integer amount, List<Long> dishes) {
        log.info("Edited order {}", id);
        OrderEntity orderEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can not find order " + id));
        if (address != null) {
            orderEntity.setAddress(address);
        }
        if (amount != null) {
            orderEntity.setAmount(amount);
        }
        if (dishes != null) {
            List<DishEntity> listOfDishEntity = Optional.ofNullable(dishes)
                    .orElse(Collections.emptyList()).stream()
                    .map(x -> dishService.get(x))
                    .collect(Collectors.toList());
            orderEntity.setDishes(listOfDishEntity);
        }
        repository.save(orderEntity);
    }
}
