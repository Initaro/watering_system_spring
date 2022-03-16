package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.WateringHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WateringHourRepository extends JpaRepository<WateringHour, Integer> {}