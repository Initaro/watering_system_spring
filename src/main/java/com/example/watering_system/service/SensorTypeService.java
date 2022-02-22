package com.example.watering_system.service;

import com.example.watering_system.data.entity.SensorType;

import java.util.List;

public interface SensorTypeService {
    List<SensorType> getSensorTypeService();

    SensorType getSensorTypeService(int id);

    SensorType createSensorType(SensorType sensorType);

    SensorType updateSensorType(SensorType sensorType, int id);

    void deleteSensorTypeService(int id);
}
