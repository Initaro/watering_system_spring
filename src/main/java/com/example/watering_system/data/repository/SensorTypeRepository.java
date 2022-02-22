package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepository extends JpaRepository<SensorType, Integer> {}