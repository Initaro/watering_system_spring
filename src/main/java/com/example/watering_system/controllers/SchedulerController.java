package com.example.watering_system.controllers;

import com.example.watering_system.config.ScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    @Autowired
    private ScheduledTask scheduledTask;

    //http://localhost/api/scheduler?enabled=true
    @PostMapping
    public void updateScheduler(@RequestParam(name = "enabled") Boolean enabled) {
        if (enabled) {
            scheduledTask.enableScheduler();
        } else {
            scheduledTask.disableScheduler();
        }
    }

    @GetMapping
    public boolean getStatus() {
        return scheduledTask.isEnabled();
    }
}