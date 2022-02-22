package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {}