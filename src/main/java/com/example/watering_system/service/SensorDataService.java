package com.example.watering_system.service;

import com.example.watering_system.data.entity.SensorData;

import java.util.List;

public interface SensorDataService {
    List<SensorData> getSensorDataService();

    SensorData getSensorDataService(int id);

    SensorData createSensorData(SensorData sensorData);

    SensorData updateSensorData(SensorData sensorData, int id);

    void deleteSensorDataService(int id);
}