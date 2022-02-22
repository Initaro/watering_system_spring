package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.Log;
import com.example.watering_system.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/log")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<Log> getLog() {
        return logService.getLogService();
    }

    @RequestMapping("/{id}")
    public Log getLog(@PathVariable("id") int id) {
        return logService.getLogService(id);
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.createLog(log);
    }

    @PutMapping(value = "/{id}")
    public Log updateLog(@RequestBody Log log, @PathVariable("id") int id) {
        return logService.updateLog(log, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteLog(@PathVariable("id") int id) {
        logService.deleteLogService(id);
    }
}