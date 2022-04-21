package com.example.watering_system.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.watering_system.SpringHttpClient.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void restClient() {
        System.out.println("Works!!!");
        RestClient restClient = new RestClient();

        restClient.get();
    }

    /*public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }*/
}