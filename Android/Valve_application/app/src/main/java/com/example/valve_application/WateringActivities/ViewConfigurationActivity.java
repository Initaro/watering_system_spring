package com.example.valve_application.WateringActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.valve_application.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entity.Configuration;
import entity.WateringHour;

public class ViewConfigurationActivity extends AppCompatActivity {
    Button returnButton;
    Button saveButton;

    TextView activeTimeText;
    EditText activeTimeEdit;

    CheckBox monday;
    CheckBox tuesday;
    CheckBox wednesday;
    CheckBox thursday;
    CheckBox friday;
    CheckBox saturday;
    CheckBox sunday;

    TextView firstWateringText;
    EditText firstWateringEdit;

    TextView secondWateringText;
    EditText secondWateringEdit;

    TextView thirdWateringText;
    EditText thirdWateringEdit;

    WateringHour[] wateringHours;

    private void getWateringHoursDeserialization() throws IOException {
        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/wateringHour"); //computer
        HttpGet request = new HttpGet("http://192.168.1.103:8080/api/wateringHour"); //raspberry
        HttpResponse response = client.execute(request);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        wateringHours = gson.fromJson(bufferedReader, WateringHour[].class);
    }

    private void sendConfiguration(Configuration configuration) throws IOException {
        HttpClient client = new DefaultHttpClient();
//        HttpPut httpPut = new HttpPut("http://192.168.1.101:8080/api/configuration/1"); //computer
        HttpPut httpPut = new HttpPut("http://192.168.1.103:8080/api/configuration/1"); //raspberry

        Gson gson = new Gson();
        String json = gson.toJson(configuration);
        json = json.replace("}", ",\"valveId\":1}");

        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Content-type", "application/json");

        client.execute(httpPut);
    }

    private void sendWateringHour(List<WateringHour> wateringHourList) throws IOException {
        HttpClient client = new DefaultHttpClient();
//        HttpPut httpPutHour1 = new HttpPut("http://192.168.1.101:8080/api/wateringHour/1"); //computer
//        HttpPut httpPutHour2 = new HttpPut("http://192.168.1.101:8080/api/wateringHour/2"); //computer
//        HttpPut httpPutHour3 = new HttpPut("http://192.168.1.101:8080/api/wateringHour/3"); //computer
        HttpPut httpPutHour1 = new HttpPut("http://192.168.1.103:8080/api/wateringHour/1"); //raspberry
        HttpPut httpPutHour2 = new HttpPut("http://192.168.1.103:8080/api/wateringHour/2"); //raspberry
        HttpPut httpPutHour3 = new HttpPut("http://192.168.1.103:8080/api/wateringHour/3"); //raspberry

        Gson gson = new Gson();
        String json1 = gson.toJson(wateringHourList.get(0));
        json1 = json1.replace("}", ",\"configurationId\":1}");
        String json2 = gson.toJson(wateringHourList.get(1));
        json2 = json2.replace("}", ",\"configurationId\":1}");
        String json3 = gson.toJson(wateringHourList.get(2));
        json3 = json3.replace("}", ",\"configurationId\":1}");

        StringEntity entity1 = new StringEntity(json1);
        StringEntity entity2 = new StringEntity(json2);
        StringEntity entity3 = new StringEntity(json3);

        httpPutHour1.setEntity(entity1);
        httpPutHour1.setHeader("Content-type", "application/json");
        client.execute(httpPutHour1);

        httpPutHour2.setEntity(entity2);
        httpPutHour2.setHeader("Content-type", "application/json");
        client.execute(httpPutHour2);

        httpPutHour3.setEntity(entity3);
        httpPutHour3.setHeader("Content-type", "application/json");
        client.execute(httpPutHour3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_configurations);

        Intent i = getIntent();
        Configuration configuration = (Configuration) i.getExtras().get("configurationIdListView");

        try {
            getWateringHoursDeserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int activeTimeCounter = configuration.getWateringActiveCounter();

        returnButton = findViewById(R.id.returnButtonViewConfiguration);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Configuration configuration = new Configuration();

                configuration.setActiveTime(Integer.parseInt(activeTimeEdit.getText().toString()));
                configuration.setWateringActiveCounter(activeTimeCounter);

                if(monday.isChecked()){
                    configuration.setMonday(true);
                }

                if(tuesday.isChecked()){
                    configuration.setTuesday(true);
                }

                if(wednesday.isChecked()){
                    configuration.setWednesday(true);
                }

                if(thursday.isChecked()){
                    configuration.setThursday(true);
                }

                if(friday.isChecked()){
                    configuration.setFriday(true);
                }

                if(saturday.isChecked()){
                    configuration.setSaturday(true);
                }

                if(sunday.isChecked()){
                    configuration.setSunday(true);
                }

                try {
                    sendConfiguration(configuration);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                List<WateringHour> wateringHourList = new ArrayList<>();

                wateringHourList.add(new WateringHour(1, firstWateringEdit.getText().toString()));
                wateringHourList.add(new WateringHour(2, secondWateringEdit.getText().toString()));
                wateringHourList.add(new WateringHour(3, thirdWateringEdit.getText().toString()));

                try {
                    sendWateringHour(wateringHourList);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                switchActivitiesMain();
            }
        });

        activeTimeText = findViewById(R.id.activeTimeText);
        activeTimeEdit = findViewById(R.id.activeTimeEdit);
        activeTimeEdit.setText("" + configuration.getActiveTime());

        monday = findViewById(R.id.monday);
        monday.setChecked(configuration.getMonday());
        tuesday = findViewById(R.id.tuesday);
        tuesday.setChecked(configuration.getTuesday());
        wednesday = findViewById(R.id.wednesday);
        wednesday.setChecked(configuration.getWednesday());
        thursday = findViewById(R.id.thursday);
        thursday.setChecked(configuration.getThursday());
        friday = findViewById(R.id.friday);
        friday.setChecked(configuration.getFriday());
        saturday = findViewById(R.id.saturday);
        saturday.setChecked(configuration.getSaturday());
        sunday = findViewById(R.id.sunday);
        sunday.setChecked(configuration.getSunday());

        firstWateringText = findViewById(R.id.firstWateringText);
        firstWateringEdit = findViewById(R.id.firstWateringEdit);
        firstWateringEdit.setText("" + wateringHours[0].getTime());

        secondWateringText = findViewById(R.id.secondWateringText);
        secondWateringEdit = findViewById(R.id.secondWateringEdit);
        secondWateringEdit.setText("" + wateringHours[1].getTime());

        thirdWateringText = findViewById(R.id.thirdWateringText);
        thirdWateringEdit = findViewById(R.id.thirdWateringEdit);
        thirdWateringEdit.setText("" + wateringHours[2].getTime());

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesMain();
            }
        });
    }

    private void switchActivitiesMain() {
        Intent switchActivityIntent = new Intent(this, Watering.class);
        startActivity(switchActivityIntent);
    }
}