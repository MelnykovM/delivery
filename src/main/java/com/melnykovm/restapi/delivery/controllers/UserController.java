package com.melnykovm.restapi.delivery.controllers;

import com.melnykovm.restapi.delivery.mappers.UserMapper;
import com.melnykovm.restapi.delivery.models.UserModel;
import com.melnykovm.restapi.delivery.services.UserService;
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
@RequestMapping(path = "/api/v1/users", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @Autowired
    public UserController(UserService userService, @Lazy UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        List<UserModel> allUsers = Optional.ofNullable(userService.getAll())
                .orElse(Collections.emptyList()).stream()
                .map(x -> mapper.toModel(x))
                .collect(Collectors.toList());
        return allUsers;
    }

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable(value = "id") long id) {

        return mapper.toModel(userService.get(id));
    }

    @PostMapping
    public UserModel createUser(@RequestParam(defaultValue = "Anonimus") String name,
                                @RequestParam(defaultValue = "NoPhoneNumber") String phoneNumber,
                                @RequestParam(defaultValue = "false", required = false) boolean isVIP) {
        return mapper.toModel(userService.create(name, phoneNumber, isVIP));
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestParam Long id,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String phoneNumber) {
        userService.update(id, name, phoneNumber);
        return ResponseEntity.ok("User " + id + " was updated");

    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return ResponseEntity.ok("User " + id + " was deleted");

    }
}