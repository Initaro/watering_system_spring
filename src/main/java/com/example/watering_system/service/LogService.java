package com.example.watering_system.service;

import com.example.watering_system.data.entity.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogService();

    Log getLogService(int id);

    Log createLog(Log log);

    Log updateLog(Log log, int id);

    void deleteLogService(int id);

    List<Log> findAllByOrderByLogIdDesc();

    List<Log> findByLogLevelOrderByLogIdDesc(String logLevel);
}