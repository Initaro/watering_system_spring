package com.example.watering_system.data.dao;


import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * {"temperature": 24.00, "humidity": 15, "TODO soil": 25}
 */
public class DeviceData {
    private Float temperature;
    private Float humidity;
    private Float soil;

    public DeviceData(String json) throws JsonProcessingException {
        System.out.println("Will try to parse: " + json);
        String[] split = json.split(";");
        this.soil = Float.valueOf(split[0]);
        this.temperature = Float.valueOf(split[1]);
        this.humidity = Float.valueOf(split[2]);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public float getSoil() {
        return soil;
    }

    public void setSoil(Float soil) {
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