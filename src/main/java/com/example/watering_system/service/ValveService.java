package com.example.watering_system.service;

import com.example.watering_system.data.entity.Valve;

import java.util.List;

public interface ValveService {
    List<Valve> getValveService();

    Valve getValveService(int id);

    Valve createValve(Valve valve);

    Valve updateValve(Valve valve, int id);

    void deleteValveService(int id);
}