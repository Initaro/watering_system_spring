package com.example.watering_system.data.repository;

import com.example.watering_system.data.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Integer> {
    List<Log> findAllByOrderByLogIdDesc();

    List<Log> findByLogLevelOrderByLogIdDesc(String logLevel);
}