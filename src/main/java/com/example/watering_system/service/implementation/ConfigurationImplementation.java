package com.example.watering_system.service.implementation;

import com.example.watering_system.data.entity.Configuration;
import com.example.watering_system.data.repository.ConfigurationRepository;
import com.example.watering_system.service.ConfigurationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationImplementation implements ConfigurationService {

    private final ConfigurationRepository configurationsRepository;

    public ConfigurationImplementation(ConfigurationRepository configurationsRepository) {
        this.configurationsRepository = configurationsRepository;
    }

    public ConfigurationRepository getConfigurationsRepository() {
        return configurationsRepository;
    }

    @Override
    public List<Configuration> getConfigurationService() {
        return configurationsRepository.findAll();
    }

    @Override
    public Configuration getConfigurationService(int id) {
        return configurationsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid configuration id: " + id));
    }

    @Override
    public Configuration createConfiguration(Configuration configuration) {
        return configurationsRepository.save(configuration);
    }

    @Override
    public Configuration updateConfiguration(Configuration configuration, int id) {
        configuration.setConfigurationId(id);

        return configurationsRepository.save(configuration);
    }

    @Override
    public void deleteConfigurationService(int id) {
        configurationsRepository.deleteById(id);
    }

    @Override
    public int getActiveTime(int id) {
        Configuration configuration = getConfigurationService(id);

        return configuration.getActiveTime();
    }
}