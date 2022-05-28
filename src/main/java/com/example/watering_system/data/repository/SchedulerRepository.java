package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Scheduler, Integer>{}