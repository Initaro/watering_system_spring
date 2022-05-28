package com.example.watering_system.controllers;

import com.example.watering_system.config.ScheduledTask;
import com.example.watering_system.data.entity.Scheduler;
import com.example.watering_system.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    @Autowired
    private ScheduledTask scheduledTask;

    @Autowired
    private SchedulerService schedulerService;

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
    public String getStatus() {
        return Boolean.toString(schedulerService.getSchedulerById(1).getState());
    }

    @RequestMapping("/{id}")
    public Scheduler getScheduler(@PathVariable("id") int id) {
        return schedulerService.getSchedulerById(id);
    }

    @PostMapping
    public Scheduler createScheduler(@RequestBody Scheduler scheduler) {
        return schedulerService.createScheduler(scheduler);
    }

    @PutMapping(value = "/{id}")
    public Scheduler updateScheduler(@RequestBody Scheduler scheduler) {
        return schedulerService.updateScheduler(scheduler);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteScheduler(@PathVariable("id") int id) {
        schedulerService.deleteSchedulerService(id);
    }
}