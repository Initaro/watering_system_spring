package com.example.watering_system.service;

import com.example.watering_system.data.entity.WateringHour;

import java.util.List;

public interface WateringHourService {
    List<WateringHour> getWateringHourService();

    WateringHour getWateringHourService(int id);

    WateringHour createWateringHour(WateringHour wateringHour);

    WateringHour updateWateringHour(WateringHour wateringHour, int id);

    void deleteWateringHourService(int id);
}