package com.example.watering_system.service;

import com.example.watering_system.data.entity.Configuration;

import java.util.List;

public interface ConfigurationService {
    List<Configuration> getConfigurationService();

    Configuration getConfigurationService(int id);

    Configuration createConfiguration(Configuration configuration);

    Configuration updateConfiguration(Configuration configuration, int id);

    void deleteConfigurationService(int id);

    int getActiveTime(int id);
}