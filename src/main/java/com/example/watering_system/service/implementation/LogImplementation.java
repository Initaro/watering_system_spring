package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Log;
import com.example.watering_system.data.entity.User;
import com.example.watering_system.data.repository.LogRepository;
import com.example.watering_system.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogImplementation implements LogService {

    private final LogRepository logRepository;

    public LogImplementation(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> getLogService() {
        return logRepository.findAll();
    }

    @Override
    public Log getLogService(int id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id: " + id));
    }

    @Override
    public Log createLog(Log log) {
        return logRepository.saveAndFlush(log);
    }

    @Override
    public Log updateLog(Log log, int id) {
        log.setLogId(id);
        return logRepository.save(log);
    }

    @Override
    public void deleteLogService(int id) {
        logRepository.deleteById(id);
    }
}