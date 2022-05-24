package com.example.valve_application.SensorsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.valve_application.MainActivity;
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

import entity.SensorData;

public class ListDataActivity extends AppCompatActivity {

    Button returnButton;
    TextView temperatureOfAir;
    TextView humidityOfAir;
    TextView soilHumidity;

    SensorData[] sensorData;

    private void getSensorsDataDeserialization() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/sensorData"); //computer
        //HttpGet request = new HttpGet("http://192.168.1.103:8080/api/sensorData"); //raspberry
        HttpResponse response = client.execute(request);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        sensorData = gson.fromJson(bufferedReader, SensorData[].class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sensor_data);

        try {
            getSensorsDataDeserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

        returnButton = findViewById(R.id.returnButton);

        temperatureOfAir = (TextView) findViewById(R.id.temperatureOfAir);
        //temperatureOfAir.setText("" + sensorData[0]);
        humidityOfAir = (TextView) findViewById(R.id.humidityOfAir);
        soilHumidity = (TextView) findViewById(R.id.soilHumidity);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesMain();
            }
        });
    }

    private void switchActivitiesMain() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}