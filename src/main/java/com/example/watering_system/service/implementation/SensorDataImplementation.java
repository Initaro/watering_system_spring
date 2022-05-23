package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Sensor;
import com.example.watering_system.data.entity.SensorData;
import com.example.watering_system.data.repository.SensorDataRepository;
import com.example.watering_system.service.SensorDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataImplementation implements SensorDataService {

    private final SensorDataRepository sensorDataRepository;

    public SensorDataImplementation(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @Override
    public List<SensorData> getSensorDataService() {
        return sensorDataRepository.findAll();
    }

    @Override
    public SensorData getSensorDataService(int id) {
        return sensorDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensorData id: " + id));
    }

    @Override
    public SensorData createSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }

    @Override
    public SensorData updateSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }

    @Override
    public void deleteSensorDataService(int id) {
        sensorDataRepository.deleteById(id);
    }

    @Override
    public SensorData findTopBySensorIdOrderBySensorDataIdDesc(Sensor sensor) {
        return sensorDataRepository.findTopBySensorIdOrderBySensorDataIdDesc(sensor);
    }
}