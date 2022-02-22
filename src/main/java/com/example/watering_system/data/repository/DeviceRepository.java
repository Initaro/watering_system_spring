package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {}