package com.example.watering_system.config;

import com.example.watering_system.SpringHttpClient.RestClient;
import com.example.watering_system.data.dao.DeviceData;
import com.example.watering_system.data.entity.*;
import com.example.watering_system.data.repository.SensorRepository;
import com.example.watering_system.data.repository.ValveRepository;
import com.example.watering_system.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    ValveRepository valveRepository;

    @Autowired
    RestClient restClient;

    @Autowired
    DeviceService deviceService;

    @Autowired
    ConfigurationService confService;

    @Autowired
    WateringHourService wateringHourService;

    @Autowired
    SensorDataService sensorDataService;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    SchedulerService schedulerService;

    @Scheduled(fixedRate = 60000)
    public void worker() {
        if (schedulerService.getSchedulerById(1).getState()) {
            System.out.println("Scheduler running...");
            List<SensorData> sensorDataList = new ArrayList<>();

            //check the soil moisture data
            List<Valve> allValves = valveRepository.findAll();
            System.out.println("All valves: " + allValves);
            for (Valve valve : allValves) {
                System.out.println("Current valve: " + valve);
                //validate if the last operation has worked
                if (!validateFailedOperation(valve)) { //if the valve doesn't activate it skips the watering
                    System.out.println("Operation failed counter reached. System will not try to re-activate");
                }

                //check current soil moisture data
                //TODO: add temperature, air moisture, barometric pressure critical level measurements
                //esp 8266 - 10-bit analog (0-1023)
                Device device = deviceService.getAllDevices().get(0);
                System.out.println("Will process the device: " + device);
                try {
                    System.out.println("Will try to read sensor data from device: " + device.getDeviceEndpoint());
                    DeviceData deviceData = new DeviceData(restClient.getDataFromDevice(device.getDeviceEndpoint()));
                    System.out.println("device data: " + deviceData);

                    List<Sensor> allByDeviceId = sensorRepository.getAllByDeviceId(device.getDeviceId());

                    float soilData = 0;

                    for (Sensor sensor : allByDeviceId) {
                        if (sensor.getSensorTypeId().getSensorType().equalsIgnoreCase("Temperature")) {
                            sensorDataList.add(new SensorData(sensor, "" + deviceData.getTemperature(), new Date()));
                        }

                        if (sensor.getSensorTypeId().getSensorType().equalsIgnoreCase("Soil")) {
                            sensorDataList.add(new SensorData(sensor, "" + deviceData.getSoil(), new Date()));
                            soilData = deviceData.getSoil();
                        }

                        if (sensor.getSensorTypeId().getSensorType().equalsIgnoreCase("Humidity")) {
                            sensorDataList.add(new SensorData(sensor, "" + deviceData.getHumidity(), new Date()));
                        }
                    }

                    // for questions only - read 3 times to be sure
                    if (soilData <= 10 && !valve.isValveRunning()) {
                        try {
                            System.out.println("I GET TO HERE (ON - TRY)");
                            restClient.executeOperation(valve, valve.getValveOnEndpoint());
                            System.out.println(valve.getValveOnEndpoint());
                            valve.setValveRunning(true);
                        } catch (IOException e) {
                            System.out.println("I GET TO HERE (ON - CATCH)" + e.getMessage());
                            valve.setValveFailedEndPoint(valve.getValveOnEndpoint());
                            valve.setValveFailedOperation(true);
                            valve.setValveFailedCounter(valve.getValveFailedCounter() + 1);
                        }
                    }
                    if (soilData >= 80 && valve.isValveRunning()) { //TODO - tova ne mi haresva
                        try {
                            System.out.println("I GET TO HERE (OFF - TRY)");
                            restClient.executeOperation(valve, valve.getValveOffEndpoint());
                            System.out.println(valve.getValveOffEndpoint());
                            valve.setValveRunning(false);
                        } catch (IOException e) {
                            System.out.println("I GET TO HERE (OFF - CATCH)" + e.getMessage());
                            valve.setValveFailedEndPoint(valve.getValveOffEndpoint());
                            valve.setValveFailedOperation(false);
                            valve.setValveFailedCounter(valve.getValveFailedCounter() + 1);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("ERROR: Unable to read sensor data from: " + device.getDeviceEndpoint()
                            + ", reason: " + e.getMessage());
                    e.printStackTrace();

                }

                //proceed with automation
                //day of watering
                //hours of watering
                //time of the watering
                LocalDate now = LocalDate.now();
                DayOfWeek dayOfWeek = now.getDayOfWeek();
                int value = dayOfWeek.getValue();
                System.out.println("Current day of week: " + value);

                LocalTime time = LocalTime.now();
                int hour = time.getHour();
                int minute = time.getMinute();
                System.out.println("Current hour of day is: " + hour);

                // TODO more configurations after android is ready
                Configuration configuration = confService.getConfigurationService(1);
                int activeTime = confService.getActiveTime(1);// conf id
                System.out.println("Active time (period): " + activeTime);

                List<WateringHour> allHours = this.wateringHourService.getWateringHourService();

                // Check if active timer is reached
                System.out.println("Is valve running: " + valve.isValveRunning());
                if (valve.isValveRunning() && configuration.getWateringActiveCounter() >= activeTime) {
                    try {
                        restClient.executeOperation(valve, valve.getValveOffEndpoint());
                        valve.setValveRunning(false);
                    } catch (IOException e) {
                        valve.setValveFailedEndPoint(valve.getValveOffEndpoint());
                        valve.setValveFailedOperation(false);
                        valve.setValveFailedCounter(valve.getValveFailedCounter() + 1);
                        System.out.println("Unable to execute operation. Valve off " + e.getMessage());
                    }
                    // if the operation failed or not, the active time is reached, so we clear the counter
                    configuration.setWateringActiveCounter(0);
                } else if (valve.isValveRunning()) {
                    if(configuration.getWateringActiveCounter() != null) {
                        configuration.setWateringActiveCounter(configuration.getWateringActiveCounter() + 1);
                    }else{
                        configuration.setWateringActiveCounter(0);
                    }
                } else {
                    if (shouldWateringThisDay(configuration, dayOfWeek.getValue())) {
                        DB_HOURS:
                        for (WateringHour wateringHour : allHours) {
                            String[] split = wateringHour.getTime().split(":");

                            if (hour == Integer.parseInt(split[0])) {
                                if (minute == Integer.parseInt(split[1]) && !valve.isValveRunning()) {
                                    try {
                                        System.out.println("WATERING: ACTIVATED");
                                        configuration.setWateringActiveCounter(0);
                                        restClient.executeOperation(valve, valve.getValveOnEndpoint());
                                        valve.setValveRunning(true);
                                    } catch (IOException e) {
                                        valve.setValveFailedEndPoint(valve.getValveOnEndpoint());
                                        valve.setValveFailedOperation(true);
                                        valve.setValveFailedCounter(valve.getValveFailedCounter() + 1);
                                        System.out.println("Unable to activate watering " + e.getMessage());
                                    }
                                }
                            }
                        }
                    }
                }

                // Update the values
                valveRepository.save(valve);
                confService.updateConfiguration(configuration, configuration.getConfigurationId());
                sensorDataList.forEach(sensorData -> sensorDataService.updateSensorData(sensorData));
            }
        }
    }

    private boolean shouldWateringThisDay(Configuration configuration, int dayOfWeek) {
        if ((dayOfWeek == 1 && configuration.getMonday())
                || (dayOfWeek == 2 && configuration.getThursday())
                || (dayOfWeek == 3 && configuration.getWednesday())
                || (dayOfWeek == 4 && configuration.getThursday())
                || (dayOfWeek == 5 && configuration.getFriday())
                || (dayOfWeek == 6 && configuration.getSaturday())
                || (dayOfWeek == 7 && configuration.getSunday())) {
            return true;
        }
        return false;
    }

    private boolean validateFailedOperation(Valve valve) {
        if (valve.isFailedOperation()) {
            Integer valveFailedCounter = valve.getValveFailedCounter();

            if (valveFailedCounter >= 10) { //TODO - continue to notify and make fallback mechanism
                return false;
            }

            try { /*За подобрение на системата е най-добре да се свърже второ физическо реле, която да прекъсне тока при повреда без нуждата от връзка към рутера */
                System.out.println("Try to execute last failed endpoint: " + valve.getValveFailedEndPoint());
                restClient.executeOperation(valve, valve.getValveFailedEndPoint());
                valve.setValveFailedEndPoint("");
                valve.setValveFailedOperation(false);
                valveFailedCounter = 0;
            } catch (IOException e) {
                valve.setValveFailedCounter(valveFailedCounter + 1);
                System.out.println("Unable to get failed endpoint " + e.getMessage());
            }
        }
        return true;
    }
}