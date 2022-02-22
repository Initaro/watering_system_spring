package com.example.watering_system.service;

import com.example.watering_system.data.entity.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getSensorService();

    Sensor getSensorService(int id);

    Sensor createSensor(Sensor sensor);

    Sensor updateSensor(Sensor sensor, int id);

    void deleteSensorService(int id);
}