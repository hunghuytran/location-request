package com.locationrequest.library.java.main;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.URL;

public class LocationHttpRequests {
    public String connect(URL url) {
        try {
            HttpResponse response = Unirest.get(url.toString()).asJson();
            return response.getBody().toString();
        } catch (UnirestException e) {
            return "{\"error_message\":\"Connection failure.\"}";
        }
    }
}
