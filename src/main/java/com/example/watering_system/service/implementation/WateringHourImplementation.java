package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.WateringHour;
import com.example.watering_system.data.repository.WateringHourRepository;
import com.example.watering_system.service.WateringHourService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WateringHourImplementation implements WateringHourService {

    private final WateringHourRepository wateringHourRepository;

    public WateringHourImplementation(WateringHourRepository wateringHourRepository) {
        this.wateringHourRepository = wateringHourRepository;
    }

    @Override
    public List<WateringHour> getWateringHourService() {
        return wateringHourRepository.findAll();
    }

    @Override
    public WateringHour getWateringHourService(int id) {
        return wateringHourRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid watering hour id: " + id));
    }

    @Override
    public WateringHour createWateringHour(WateringHour wateringHour) {
        return wateringHourRepository.save(wateringHour);
    }

    @Override
    public WateringHour updateWateringHour(WateringHour wateringHour, int id) {
        wateringHour.setWateringHoursId(id);

        return wateringHourRepository.save(wateringHour);
    }

    @Override
    public void deleteWateringHourService(int id) {
        wateringHourRepository.deleteById(id);
    }
}