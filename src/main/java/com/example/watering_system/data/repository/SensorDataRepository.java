package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Sensor;
import com.example.watering_system.data.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {
    SensorData findTopBySensorIdOrderBySensorDataIdDesc(Sensor sensor);
}