package com.example.demo.service.implementation;

import com.example.demo.data.entity.Log;
import com.example.demo.data.repository.LogsRepository;
import com.example.demo.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogImplementation implements LogService {

    private final LogsRepository logsRepository;

    public LogImplementation(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    public LogsRepository getLogsRepository() {
        return logsRepository;
    }

    @Override
    public List<Log> getLog() {
        return logsRepository.findAll();
    }

    @Override
    public Log getLog(long id) {
        return logsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public Log create(Log log) {
        return logsRepository.save(log);
    }

    @Override
    public void deleteLog(long id) {
        logsRepository.deleteById(id);
    }
}