package com.example.valve_application.LogsActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.valve_application.MainActivity;
import com.example.valve_application.R;

public class LogsActivity extends AppCompatActivity {

    Button returnButton;
    Button wateringLogs;
    Button warningLogs;
    Button errorLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        returnButton = findViewById(R.id.returnButton);
        wateringLogs = findViewById(R.id.viewWateringLogs);
        warningLogs = findViewById(R.id.viewWarningLogs);
        errorLogs = findViewById(R.id.viewErrorLogs);

        wateringLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchWateringLogs();
            }
        });

        warningLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchWarningLogs();
            }
        });

        errorLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchErrorLogs();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesMain();
            }
        });
    }

    private void switchWateringLogs() {
        Intent switchActivityIntent = new Intent(this, WateringLogsActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchWarningLogs() {
        Intent switchActivityIntent = new Intent(this, WarningLogsActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchErrorLogs() {
        Intent switchActivityIntent = new Intent(this, ErrorLogsActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesMain() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}