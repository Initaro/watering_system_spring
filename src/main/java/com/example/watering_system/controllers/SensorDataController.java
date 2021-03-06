package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.Sensor;
import com.example.watering_system.data.entity.SensorData;
import com.example.watering_system.service.SensorDataService;
import com.example.watering_system.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensorData")
public class SensorDataController {
    @Autowired
    SensorService sensorService;

    private final SensorDataService sensorDataService;

    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @GetMapping
    public List<SensorData> getSensorData() {
        return sensorDataService.getSensorDataService();
    }

    @RequestMapping("/{id}")
    public SensorData getSensorData(@PathVariable("id") int id) {
        return sensorDataService.getSensorDataService(id);
    }

    @PostMapping
    public SensorData createSensorData(@RequestBody SensorData sensorData) {
        return sensorDataService.createSensorData(sensorData);
    }

    @PutMapping(value = "/{id}")
    public SensorData updateSensorData(@RequestBody SensorData sensorData) {
        return sensorDataService.updateSensorData(sensorData);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteSensorData(@PathVariable("id") int id) {
        sensorDataService.deleteSensorDataService(id);
    }

    @GetMapping("/get/{sensorId}")
    public String findTopBySensorIdOrderBySensorDataIdDesc(@PathVariable("sensorId") int sensorId) {
        Sensor sensorById = sensorService.getSensorById(sensorId);

        return sensorDataService.findTopBySensorIdOrderBySensorDataIdDesc(sensorById).getSensorValue();
    }
}