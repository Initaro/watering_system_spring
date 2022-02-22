package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Valve;
import com.example.watering_system.data.repository.ValveRepository;
import com.example.watering_system.service.ValveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValveImplementation implements ValveService {

    private final ValveRepository valveRepository;

    public ValveImplementation(ValveRepository valveRepository) {
        this.valveRepository = valveRepository;
    }

    @Override
    public List<Valve> getValveService() {
        return valveRepository.findAll();
    }

    @Override
    public Valve getValveService(int id) {
        return valveRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid valve id: " + id));
    }

    @Override
    public Valve createValve(Valve valve) {
        return valveRepository.save(valve);
    }

    @Override
    public Valve updateValve(Valve valve, int id) {
        valve.setValveId(id);

        return valveRepository.save(valve);
    }

    @Override
    public void deleteValveService(int id) {
        valveRepository.deleteById(id);
    }
}