package com.melnykovm.restapi.delivery.controllers;

import com.melnykovm.restapi.delivery.mappers.OrderMapper;
import com.melnykovm.restapi.delivery.models.OrderModel;
import com.melnykovm.restapi.delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {
    public final OrderService orderService;
    private final OrderMapper mapper;

    @Autowired
    public OrderController(OrderService orderService, @Lazy OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrderModel> getAllOrders() {
        List<OrderModel> allOrders = Optional.ofNullable(orderService.getAll())
                .orElse(Collections.emptyList()).stream()
                .map(x -> mapper.toModel(x))
                .collect(Collectors.toList());
        return allOrders;
    }

    @GetMapping("/{id}")
    public OrderModel getOrder(@PathVariable(value = "id") long id) {
        return mapper.toModel(orderService.get(id));
    }

    @PostMapping
    public OrderModel createOrder(@RequestParam Long userId,
                                  @RequestParam String address,
                                  @RequestParam Integer amount,
                                  @RequestParam List<Long> dishes) {
        return mapper.toModel(orderService.create(userId, address, amount, dishes));
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestParam Long id,
                                      @RequestParam(required = false) String address,
                                      @RequestParam(required = false) Integer amount,
                                      @RequestParam(required = false) List<Long> dishes) {
        orderService.update(id, address, amount, dishes);
        return ResponseEntity.ok("Order " + id + " was updated");

    }

    @DeleteMapping
    public ResponseEntity deleteOrder(@RequestParam Long id) {
        orderService.delete(id);
        return ResponseEntity.ok("Order " + id + " was deleted");
    }
}
