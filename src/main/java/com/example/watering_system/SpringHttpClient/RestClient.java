package com.example.watering_system.SpringHttpClient;

import com.example.watering_system.data.entity.Valve;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class RestClient {
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        //headers.add("Accept", "*");
    }

    public String getDataFromDevice(String endpoint) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(endpoint, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        System.out.println("Returned response! " + responseEntity.getBody());
        return responseEntity.getBody();
    }

    public String executeOperation(Valve valve, String endpoint) throws IOException {
        try {
            System.out.println("Will try to execute endpoint" + endpoint);
            HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
            ResponseEntity<String> responseEntity = rest.exchange(endpoint, HttpMethod.GET, requestEntity, String.class);
            System.out.println(responseEntity);
            this.setStatus(responseEntity.getStatusCode());
            valve.setValveFailedOperation(false);
            valve.setValveFailedCounter(0);
            valve.setValveFailedEndPoint("");
            System.out.println("Returned response! " + responseEntity.getBody());
            return responseEntity.getBody();
        } catch (RestClientException e) {
            throw new IOException(e);
        }
    }

   /* public String post(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public void put(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.PUT, requestEntity, null);
        this.setStatus(responseEntity.getStatusCode());
    }

    public void delete(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.DELETE, requestEntity, null);
        this.setStatus(responseEntity.getStatusCode());
    }*/

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}