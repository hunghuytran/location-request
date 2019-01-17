package com.locationrequest.library.java.main;

import java.net.URL;

public class LocationRequest {
    private LocationHttpRequests locationHttpRequests;
    private String api;
    private UrlBuilder urlBuilder;

    public LocationRequest(String key) {
        this.locationHttpRequests = new LocationHttpRequests();
        this.api = key;
        this.urlBuilder = new UrlBuilder(this.api);
    }

    public String query(String input, String fields) {
        URL url = urlBuilder.buildUrl(input, fields);
        return retrieve(url);
    }

    public String query(String input) {
        URL url = urlBuilder.buildUrl(input);
        return retrieve(url);
    }

    private String retrieve(URL url) {
        return locationHttpRequests.connect(url);
    }
}
