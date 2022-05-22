package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.Valve;
import com.example.watering_system.service.ValveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valve")
public class ValveController {
    private final ValveService valveService;

    public ValveController(ValveService valveService) {
        this.valveService = valveService;
    }

    @GetMapping
    public List<Valve> getValve() {
        return valveService.getAllValves();
    }

    @RequestMapping("/{id}")
    public Valve getValve(@PathVariable("id") int id) {
        return valveService.getAllValves(id);
    }

    @PostMapping
    public Valve createValve(@RequestBody Valve valve) {
        return valveService.createValve(valve);
    }

    @PutMapping(value = "/{id}")
    public Valve updateValve(@RequestBody Valve valve, @PathVariable("id") int id) {
        return valveService.updateValve(valve, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteValve(@PathVariable("id") int id) {
        valveService.deleteValveService(id);
    }
}