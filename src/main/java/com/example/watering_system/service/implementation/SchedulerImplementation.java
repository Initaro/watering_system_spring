package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Scheduler;
import com.example.watering_system.data.repository.SchedulerRepository;
import com.example.watering_system.service.SchedulerService;
import org.springframework.stereotype.Service;

@Service
public class SchedulerImplementation implements SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerImplementation(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    @Override
    public Scheduler getSchedulerById(int id) {
        return schedulerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid scheduler id: " + id));
    }

    @Override
    public Scheduler createScheduler(Scheduler scheduler) {
        return schedulerRepository.save(scheduler);
    }

    @Override
    public Scheduler updateScheduler(Scheduler scheduler) {
        return schedulerRepository.save(scheduler);
    }

    @Override
    public void deleteSchedulerService(int id) {
        schedulerRepository.deleteById(id);
    }

    public void enableScheduler() {
        Scheduler scheduler = getSchedulerById(1);
        scheduler.setState(true);
        updateScheduler(scheduler);
        System.out.println(getSchedulerById(1).getState());
    }

    public void disableScheduler() {
        Scheduler scheduler = getSchedulerById(1);
        scheduler.setState(false);
        updateScheduler(scheduler);
        System.out.println(getSchedulerById(1).getState());
        System.out.println("Stopping scheduler...");
    }
}