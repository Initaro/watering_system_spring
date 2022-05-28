package com.example.watering_system.service;

import com.example.watering_system.data.entity.Scheduler;

public interface SchedulerService {
    Scheduler getSchedulerById(int id);

    Scheduler createScheduler(Scheduler scheduler);

    Scheduler updateScheduler(Scheduler scheduler);

    void deleteSchedulerService(int id);
}