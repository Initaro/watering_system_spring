package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.User;
import com.example.watering_system.data.repository.UserRepository;
import com.example.watering_system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserService {

    private final UserRepository userRepository;

    public UserImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserService() {
        return userRepository.findAll();
    }

    @Override
    public User getUserService(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, int id) {
        user.setUserId(id);

        return userRepository.save(user);
    }

    @Override
    public void deleteUserService(int id) {
        userRepository.deleteById(id);
    }
}