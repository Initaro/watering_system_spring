package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.User;
import com.example.watering_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUserService();
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUserService(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUserService(id);
    }
}