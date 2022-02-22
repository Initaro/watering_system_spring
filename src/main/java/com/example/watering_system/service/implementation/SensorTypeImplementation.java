package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.SensorType;
import com.example.watering_system.data.repository.SensorTypeRepository;
import com.example.watering_system.service.SensorTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTypeImplementation implements SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypeImplementation(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @Override
    public List<SensorType> getSensorTypeService() {
        return sensorTypeRepository.findAll();
    }

    @Override
    public SensorType getSensorTypeService(int id) {
        return sensorTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensor type id: " + id));
    }

    @Override
    public SensorType createSensorType(SensorType sensorType) {
        return sensorTypeRepository.save(sensorType);
    }

    @Override
    public SensorType updateSensorType(SensorType sensorType, int id) {
        sensorType.setSensorTypeId(id);

        return sensorTypeRepository.save(sensorType);
    }

    @Override
    public void deleteSensorTypeService(int id) {
        sensorTypeRepository.deleteById(id);
    }
}