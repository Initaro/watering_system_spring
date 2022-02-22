package com.example.watering_system.controllers;

import com.example.watering_system.data.entity.Configuration;
import com.example.watering_system.service.ConfigurationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {
    private final ConfigurationService configurationsService;

    public ConfigurationController(ConfigurationService configurationsService) {
        this.configurationsService = configurationsService;
    }

    @GetMapping
    public List<Configuration> getConfiguration() {
        return configurationsService.getConfigurationService();
    }

    @RequestMapping("/{id}")
    public Configuration getConfiguration(@PathVariable("id") int id) {
        return configurationsService.getConfigurationService(id);
    }

    @PostMapping
    public Configuration createConfiguration(@RequestBody Configuration configuration) {
        return configurationsService.createConfiguration(configuration);
    }

    @PutMapping(value = "/{id}")
    public Configuration updateConfiguration(@RequestBody Configuration configuration, @PathVariable("id") int id) {
        return configurationsService.updateConfiguration(configuration, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteConfiguration(@PathVariable("id") int id) {
        configurationsService.deleteConfigurationService(id);
    }
}