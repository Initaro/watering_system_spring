package com.example.valve_application.WateringActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.valve_application.MainActivity;
import com.example.valve_application.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entity.Configuration;

public class Watering extends AppCompatActivity {

    Button returnButton;
    Button automationControl;
    Button addConfiguration; //TODO
    //Button deleteConfiguration; //TODO
    boolean currentAutomationStatus;

    ListView listView;

    @SuppressLint("SetTextI18n")
    private void getConfigurationsDeserialization() throws IOException {
        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/configuration"); //computer
        HttpGet request = new HttpGet("http://192.168.1.103:8080/api/configuration"); //raspberry
        HttpResponse response = client.execute(request);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Configuration[] configurations = gson.fromJson(bufferedReader, Configuration[].class);

        //System.out.println(Arrays.toString(configurations)); //test
        ArrayAdapter adapter = new ArrayAdapter<Configuration>(this, R.layout.text_view, configurations);

        listView = (ListView) findViewById(R.id.configurations);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String configurationIdListView = ((TextView) arg1).getText().toString();
                Toast.makeText(getBaseContext(), configurationIdListView, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), ViewConfigurationActivity.class);

                String[] s = configurationIdListView.split(" ");

                for (Configuration configuration : configurations) {
                    if (configuration.getConfigurationId().equals(Integer.parseInt(s[1]))) {
                        intent.putExtra("configurationIdListView", configuration);
                        break;
                    }
                }
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public boolean getAutomationStatus() throws IOException {
        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet("http://192.168.1.101:8080/api/scheduler"); //computer
        HttpGet request = new HttpGet("http://192.168.1.103:8080/api/scheduler"); //raspberry
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        boolean status = Boolean.parseBoolean(result);
        setAutomationButtonText(status);

        return status;
    }

    private void updateAutomationStatus() throws IOException {
        boolean newStatus = !currentAutomationStatus;
//        String urlTemplate = "http://192.168.1.101:8080/api/scheduler"; //computer
        String urlTemplate = "http://192.168.1.103:8080/api/scheduler"; //raspberry

        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(urlTemplate);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("enabled", Boolean.toString(newStatus)));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        client.execute(httpPost);
        setAutomationButtonText(newStatus);
        currentAutomationStatus = newStatus;
    }

    private void setAutomationButtonText(boolean status) {
        if (status) {
            automationControl.setText("Enabled");
        } else {
            automationControl.setText("Disabled");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering);

        returnButton = findViewById(R.id.returnButton);
        addConfiguration = findViewById(R.id.add_watering_button);
        automationControl = findViewById(R.id.automationControl);

        try {
            currentAutomationStatus = getAutomationStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }

        automationControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    updateAutomationStatus();
                } catch (IOException e) {
                    System.out.println("Do i get to updateAutomation catch???????????" + e.getMessage());
                }
            }
        });

        try {
            getConfigurationsDeserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesMain();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesMain();
            }
        });
    }

    private void showAddActivity() {
        Intent switchActivityIntent = new Intent(this, AddWateringActivity.class);
        startActivity(switchActivityIntent);
    }

    /*private void deleteConfiguration() {}*/ //Popup window with choice of configuration

    private void switchActivitiesMain() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}