package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.Sensor;
import com.example.watering_system.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public List<Sensor> getSensor() {
        return sensorService.getSensorService();
    }

    @RequestMapping("/{id}")
    public Sensor getSensor(@PathVariable("id") int id) {
        return sensorService.getSensorService(id);
    }

    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }

    @PutMapping(value = "/{id}")
    public Sensor updateSensor(@RequestBody Sensor sensor, @PathVariable("id") int id) {
        return sensorService.updateSensor(sensor, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteSensor(@PathVariable("id") int id) {
        sensorService.deleteSensorService(id);
    }
}