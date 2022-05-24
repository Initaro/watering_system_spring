package com.example.valve_application.LogsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import java.util.Arrays;

import entity.Log;

public class WateringLogsActivity extends AppCompatActivity {

    Button returnButton;
    TextView textView;

    @SuppressLint("SetTextI18n")
    private void getLogsDeserialization() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/log/get"); //computer
        //HttpGet request = new HttpGet("http://192.168.1.103:8080/api/log"); //raspberry
        HttpResponse response = client.execute(request);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Log[] logGet = gson.fromJson(bufferedReader, Log[].class);

        //System.out.println(Arrays.toString(configurationGet)); //test
        textView.setText(Arrays.toString(logGet));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering_logs);

        returnButton = findViewById(R.id.returnButton);

        textView = (TextView) findViewById(R.id.wateringLogsTextVIew);
        textView.setMovementMethod(new ScrollingMovementMethod());

        try {
            getLogsDeserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesLogs();
            }
        });
    }

    private void switchActivitiesLogs() {
        Intent switchActivityIntent = new Intent(this, LogsActivity.class);
        startActivity(switchActivityIntent);
    }
}