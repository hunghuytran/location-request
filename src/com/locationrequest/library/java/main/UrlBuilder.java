package com.locationrequest.library.java.main;

import org.apache.http.client.utils.URIBuilder;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

public class UrlBuilder {
    private String path;
    private String key;
    private URIBuilder url;

    public UrlBuilder(String key) {
        this.path = "https://maps.googleapis.com";
        this.key = key;
    }

    public URL buildUrl(String input, String fields) {
        try {
            this.url = createURIBuilder(this.path)
                    .setParameter("input", encodeInput(input))
                    .setParameter("fields", fields);
            return url.build().toURL();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public URL buildUrl(String input) {
        try {
            this.url = createURIBuilder(this.path)
                    .setParameter("fields", "formatted_address")
                    .setParameter("input", encodeInput(input));
            return url.build().toURL();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private URIBuilder createURIBuilder(String path) {
        try {
            return new URIBuilder(path)
                    .setPath("/maps/api/place/findplacefromtext/json")
                    .setParameter("inputtype", "textquery")
                    .setParameter("key", this.key);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String encodeInput(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
