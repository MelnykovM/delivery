package com.melnykovm.restapi.delivery.controllers;

import com.melnykovm.restapi.delivery.mappers.DishMapper;
import com.melnykovm.restapi.delivery.models.DishModel;
import com.melnykovm.restapi.delivery.services.DishService;
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
@RequestMapping(path = "/api/v1/dishes", produces = APPLICATION_JSON_VALUE)
public class DishController {
    private final DishService dishService;
    private final DishMapper mapper;

    @Autowired
    public DishController(DishService dishService, @Lazy DishMapper mapper) {
        this.dishService = dishService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<DishModel> getAllDishes() {

        List<DishModel> allDishes = Optional.ofNullable(dishService.getAll())
                .orElse(Collections.emptyList()).stream()
                .map(x -> mapper.toModel(x))
                .collect(Collectors.toList());
        return allDishes;
    }

    @GetMapping("/{id}")
    public DishModel getDish(@PathVariable(value = "id") long id) {
        return mapper.toModel(dishService.get(id));
    }

    @PostMapping
    public DishModel createDish(@RequestParam String dishName) {
        return mapper.toModel(dishService.create(dishName));
    }

    @PutMapping
    public ResponseEntity updateDish(@RequestParam Long id,
                                     @RequestParam(required = false) String dishName) {
        dishService.update(id, dishName);
        return ResponseEntity.ok("Dish " + id + " was updated");
    }

    @DeleteMapping
    public ResponseEntity deleteDish(@RequestParam Long id) {
        dishService.delete(id);
        return ResponseEntity.ok("Dish " + id + " was deleted");
    }
}
