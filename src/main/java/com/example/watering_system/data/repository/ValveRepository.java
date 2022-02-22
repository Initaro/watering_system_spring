package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Valve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValveRepository extends JpaRepository<Valve, Long> {}