package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    @Query("select s from Sensor s where s.deviceId.deviceId = :id")
    List<Sensor> getAllByDeviceId(@Param("id") int id);
}