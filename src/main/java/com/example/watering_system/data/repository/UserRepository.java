package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}