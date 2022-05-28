package com.example.valve_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class LoginActivity extends AppCompatActivity {
    Button switchToSecondActivity;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        switchToSecondActivity = findViewById(R.id.connectButton);
        switchToSecondActivity.setOnClickListener(view -> {
            try {
                switchActivities();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void switchActivities() throws IOException {
        try {
            HttpClient client = new DefaultHttpClient();
//            HttpGet request = new HttpGet("http://192.168.1.101:8080/api/test"); //computer
            HttpGet request = new HttpGet("http://192.168.1.103:8080/api/test"); //raspberry

            HttpResponse response = client.execute(request);

            new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (Exception e) {
            TextView tv1 = findViewById(R.id.textView);
            tv1.setText("Unable to connect to server: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    private void readStream(InputStream inputStream) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}
}