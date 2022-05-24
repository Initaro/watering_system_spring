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
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/wateringHour"); //computer
        //HttpGet request = new HttpGet("http://192.168.1.103:8080/api/wateringHour"); //raspberry
        HttpResponse response = client.execute(request);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        wateringHours = gson.fromJson(bufferedReader, WateringHour[].class);
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

        returnButton = findViewById(R.id.returnButtonViewConfiguration);
        saveButton = findViewById(R.id.saveButton);

        activeTimeText = findViewById(R.id.activeTimeText);
        activeTimeEdit = findViewById(R.id.activeTimeEdit);
        activeTimeEdit.setText("" + configuration.getActiveTime());

        monday = findViewById(R.id.monday);
        monday.setChecked(Boolean.parseBoolean(configuration.getMonday()));
        tuesday = findViewById(R.id.tuesday);
        tuesday.setChecked(Boolean.parseBoolean(configuration.getTuesday()));
        wednesday = findViewById(R.id.wednesday);
        wednesday.setChecked(Boolean.parseBoolean(configuration.getWednesday()));
        thursday = findViewById(R.id.thursday);
        thursday.setChecked(Boolean.parseBoolean(configuration.getThursday()));
        friday = findViewById(R.id.friday);
        friday.setChecked(Boolean.parseBoolean(configuration.getFriday()));
        saturday = findViewById(R.id.saturday);
        saturday.setChecked(Boolean.parseBoolean(configuration.getSaturday()));
        sunday = findViewById(R.id.sunday);
        sunday.setChecked(Boolean.parseBoolean(configuration.getSunday()));

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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataAndSwitchActivities();
            }
        });
    }

    private void switchActivitiesMain() {
        Intent switchActivityIntent = new Intent(this, Watering.class);
        startActivity(switchActivityIntent);
    }

    private void saveDataAndSwitchActivities() {
        Intent switchActivityIntent = new Intent(this, Watering.class);
        startActivity(switchActivityIntent);
    }
}