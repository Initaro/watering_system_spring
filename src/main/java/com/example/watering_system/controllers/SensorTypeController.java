package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.SensorType;
import com.example.watering_system.service.SensorTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensorType")
public class SensorTypeController {
    private final SensorTypeService sensorTypeService;

    public SensorTypeController(SensorTypeService sensorTypeService) {
        this.sensorTypeService = sensorTypeService;
    }

    @GetMapping
    public List<SensorType> getSensorType() {
        return sensorTypeService.getSensorTypeService();
    }

    @RequestMapping("/{id}")
    public SensorType getSensorType(@PathVariable("id") int id) {
        return sensorTypeService.getSensorTypeService(id);
    }

    @PostMapping
    public SensorType createSensorType(@RequestBody SensorType sensorType) {
        return sensorTypeService.createSensorType(sensorType);
    }

    @PutMapping(value = "/{id}")
    public SensorType updateSensorType(@RequestBody SensorType sensorType, @PathVariable("id") int id) {
        return sensorTypeService.updateSensorType(sensorType, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteSensorType(@PathVariable("id") int id) {
        sensorTypeService.deleteSensorTypeService(id);
    }
}