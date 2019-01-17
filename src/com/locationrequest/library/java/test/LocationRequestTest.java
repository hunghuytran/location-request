package com.locationrequest.library.java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.locationrequest.library.java.main.LocationRequest;
import org.junit.jupiter.api.Test;


class LocationRequestTest {

    @Test
    void queryBerlinGermanyAndReturnString() {
        LocationRequest request = new LocationRequest(System.getenv("API_KEY"));
        String expected = "{\"candidates\":[{\"formatted_address\":\"Berlin, Germany\"}],\"status\":\"OK\"}";
        String response = request.query("Berlin");
        assertEquals(response, expected, "Response should be equal to expected!");
    }

    @Test
    void query14FrankfurtGermanyAndAddAdditionalFields() {
        LocationRequest request = new LocationRequest(System.getenv("API_KEY"));
        String expected = "{\"candidates\":[{\"formatted_address\":\"Feuerbachstraße 14, 60325 Frankfurt am Main" +
                ", Germany\",\"name\":\"Xenios Apartments\",\"id\":\"01f7eb7cc82619499f98c8e5baa77b1a47b02d33" +
                "\"}],\"status\":\"OK\"}";
        String response = request.query("14 Frankfurt Germany", "formatted_address,id,name");
        assertEquals(response, expected, "Response should be equal to expected!");
    }

    @Test
    void queryShouldFailAndReturnZeroResults() {
        LocationRequest request = new LocationRequest(System.getenv("API_KEY"));
        String expected = "{\"candidates\":[],\"status\":\"ZERO_RESULTS\"}";
        String response = request.query("Nowhere");
        assertEquals(response, expected, "Response should be equal to expected!");
    }

    @Test
    void queryShouldFailBecauseOfApiKey() {
        LocationRequest request = new LocationRequest("API_WRONG_KEY");
        String expected = "{\"error_message\":\"The provided API key is invalid.\",\"candidates\"" +
                ":[],\"status\":\"REQUEST_DENIED\"}";
        String response = request.query("New York city");
        assertEquals(response, expected, "Response should be equal to expected!");
    }
}