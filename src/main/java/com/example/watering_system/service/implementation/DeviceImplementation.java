package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Device;
import com.example.watering_system.data.repository.DeviceRepository;
import com.example.watering_system.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceImplementation implements DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceImplementation(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getAllDevices(int id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid device id: " + id));
    }

    @Override
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Device device, int id) {
        device.setDeviceId(id);

        return deviceRepository.save(device);
    }

    @Override
    public void deleteDeviceService(int id) {
        deviceRepository.deleteById(id);
    }
}