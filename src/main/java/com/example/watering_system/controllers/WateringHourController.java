package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.WateringHour;
import com.example.watering_system.service.WateringHourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wateringHour")
public class WateringHourController {
    private final WateringHourService wateringHourService;

    public WateringHourController(WateringHourService wateringHourService) {
        this.wateringHourService = wateringHourService;
    }

    @GetMapping
    public List<WateringHour> getWateringHour() {
        return wateringHourService.getWateringHourService();
    }

    @RequestMapping("/{id}")
    public WateringHour getWateringHour(@PathVariable("id") int id) {
        return wateringHourService.getWateringHourService(id);
    }

    @PostMapping
    public WateringHour createWateringHour(@RequestBody WateringHour wateringHour) {
        return wateringHourService.createWateringHour(wateringHour);
    }

    @PutMapping(value = "/{id}")
    public WateringHour updateWateringHour(@RequestBody WateringHour wateringHour, @PathVariable("id") int id) {
        return wateringHourService.updateWateringHour(wateringHour, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteWateringHour(@PathVariable("id") int id) {
        wateringHourService.deleteWateringHourService(id);
    }
}