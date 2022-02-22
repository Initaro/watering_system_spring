package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Sensor;
import com.example.watering_system.data.repository.SensorRepository;
import com.example.watering_system.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorImplementation implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorImplementation(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<Sensor> getSensorService() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getSensorService(int id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sensor id: " + id));
    }

    @Override
    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor updateSensor(Sensor sensor, int id) {
        sensor.setSensorId(id);

        return sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensorService(int id) {
        sensorRepository.deleteById(id);
    }
}