package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {}