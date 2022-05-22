package com.example.watering_system.data.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * {"temperature": 24.00, "humidity": 15, "TODO soil": 25}
 */
public class DeviceData {

    private float temperature;
    private float humidity;
    private float soil;

    public DeviceData(String json) throws JsonProcessingException {
        System.out.println("Will try to parse: " + json);
        String[] split = json.split(";");
        this.soil = Integer.parseInt(split[0]);
        this.temperature = Float.parseFloat(split[1]);
        this.humidity = Float.parseFloat(split[2]);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getSoil() {
        return soil;
    }

    public void setSoil(float soil) {
        this.soil = soil;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }


}
