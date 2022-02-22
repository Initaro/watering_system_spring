package com.example.watering_system.service;

import com.example.watering_system.data.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserService();

    User getUserService(int id);

    User createUser(User user);

    User updateUser(User user, int id);

    void deleteUserService(int id);
}