package com.example.valve_application.SensorsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.valve_application.MainActivity;
import com.example.valve_application.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListDataActivity extends AppCompatActivity {

    Button returnButton;
    TextView temperatureOfAir;
    TextView humidityOfAir;
    TextView soilHumidity;

    String temperatureData;
    String soilData;
    String humidityData;

    private void getSensorsDataDeserialization() throws IOException {
        HttpClient client = new DefaultHttpClient();

//        HttpGet temperatureRequest = new HttpGet("http://192.168.1.101:8080/api/sensorData/get/1"); //computer
//        HttpGet soilRequest = new HttpGet("http://192.168.1.101:8080/api/sensorData/get/2"); //computer
//        HttpGet humidityRequest = new HttpGet("http://192.168.1.101:8080/api/sensorData/get/3"); //computer
        HttpGet temperatureRequest = new HttpGet("http://192.168.1.103:8080/api/sensorData/get/1"); //raspberry
        HttpGet soilRequest = new HttpGet("http://192.168.1.103:8080/api/sensorData/get/2"); //raspberry
        HttpGet humidityRequest = new HttpGet("http://192.168.1.103:8080/api/sensorData/get/3"); //raspberry

        HttpResponse response1 = client.execute(temperatureRequest);
        HttpResponse response2 = client.execute(soilRequest);
        HttpResponse response3 = client.execute(humidityRequest);

        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(response2.getEntity().getContent()));
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(response3.getEntity().getContent()));

        temperatureData = String.valueOf(bufferedReader1.readLine());
        soilData = String.valueOf(bufferedReader2.readLine());
        humidityData = String.valueOf(bufferedReader3.readLine());
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
        temperatureOfAir.setText(temperatureData + "°C");

        humidityOfAir = (TextView) findViewById(R.id.humidityOfAir);
        humidityOfAir.setText(humidityData + "%");

        soilHumidity = (TextView) findViewById(R.id.soilHumidity);
        soilHumidity.setText(soilData + "%");

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