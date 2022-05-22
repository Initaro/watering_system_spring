package com.example.watering_system.service;

import com.example.watering_system.data.entity.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getAllDevices();

    Device getAllDevices(int id);

    Device createDevice(Device device);

    Device updateDevice(Device device, int id);

    void deleteDeviceService(int id);
}