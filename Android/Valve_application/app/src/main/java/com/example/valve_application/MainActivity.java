package com.example.valve_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.valve_application.LogsActivities.LogsActivity;
import com.example.valve_application.SensorsActivities.ListDataActivity;
import com.example.valve_application.SensorsActivities.Sensors;
import com.example.valve_application.WateringActivities.Watering;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button disconnectButton;
    Button listDataButton;
    Button viewLogsButton;
    Button configureWatering;
    Button configureSensorData;
    Button turnOnWatering;
    Button turnOffWatering;
    //Button changeLanguage; //TODO - future function

    TextView activeWateringData;

    @SuppressLint("SetTextI18n")
    private void getConfigurationDeserialization() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/configuration/activeTime/1"); //computer
        //HttpGet request = new HttpGet("http://192.168.1.103:8080/api/configuration/activeTime/1"); //raspberry
        HttpResponse response = client.execute(request);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Integer activeTimeGet = gson.fromJson(bufferedReader, Integer.class);

        //System.out.println(Arrays.toString(configurationGet)); //test
        activeWateringData.setText("" + activeTimeGet);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disconnectButton = findViewById(R.id.disconnectButton);

        listDataButton = findViewById(R.id.listDataButton);
        viewLogsButton = findViewById(R.id.viewLogsButton);
        configureWatering = findViewById(R.id.configureWatering);
        configureSensorData = findViewById(R.id.configureSensorData);

        turnOnWatering = findViewById(R.id.turnOnWatering);
        turnOnWatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet("http://192.168.1.109/cm?cmnd=Power ON");

                HttpResponse response = null;
                try {
                    response = client.execute(request);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        turnOffWatering = findViewById(R.id.turnOffWatering);
        turnOffWatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet("http://192.168.1.109/cm?cmnd=Power OFF");

                HttpResponse response = null;
                try {
                    response = client.execute(request);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        activeWateringData = (TextView) findViewById(R.id.activeWateringData);
        activeWateringData.setMovementMethod(new ScrollingMovementMethod());

        try {
            getConfigurationDeserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

        disconnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesLogin();
            }
        });

        listDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesListData();
            }
        });

        viewLogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesLogs();
            }
        });

        configureWatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesWatering();
            }
        });

        configureSensorData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesSensors();
            }
        });
    }

    private void switchActivitiesLogin() {
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesListData() {
        Intent switchActivityIntent = new Intent(this, ListDataActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesLogs() {
        Intent switchActivityIntent = new Intent(this, LogsActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesWatering() {
        Intent switchActivityIntent = new Intent(this, Watering.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesSensors() {
        Intent switchActivityIntent = new Intent(this, Sensors.class);
        startActivity(switchActivityIntent);
    }
}