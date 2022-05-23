package com.example.watering_system.service;

import com.example.watering_system.data.entity.Sensor;

import java.util.List;

public interface SensorService {
    List<Sensor> getSensorById();

    Sensor getSensorById(int id);

    Sensor createSensor(Sensor sensor);

    Sensor updateSensor(Sensor sensor, int id);

    void deleteSensorService(int id);
}