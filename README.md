# Simple Location Request Library
---
SLRL (Simple Location Request Library) is a user-friendly location retriever powered by Google Maps API. Written in Java.

## Requirements
  - Google API Key for Places API.
  - Java IDE. 

## Features

  - Query a location.
  - Include additional fields (optional, more info at [Google Places API](https://developers.google.com/places/web-service/search)).

## Libraries

* [Unirest](http://unirest.io) - simplified, lightweight HTTP request client.
* [URIBuilder](https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/client/utils/URIBuilder.html) - build URLs.
* [JUnit](https://junit.org/junit5/) - testing framework.

## Setup the library
  - Download the .jar dependency.
  - Import the dependency into your project. (file → project structure → modules → + ) ([Intellij](https://www.jetbrains.com/idea))

## Setup for JUnit
  - Download the project zip file, unzip, and open it in your IDE.
  - Open run configurations for the LocationRequestTest. (run → edit configurations)
  - Add an environment variables called API_KEY and use your Google API key.
  - Run the LocationRequestTest.
 
## Usage
In order to use the library, the user has to instantiate the LocationRequest class from the dependency. Here is the first step to get you started:

```
LocationRequest request = new LocationRequest("YOUR_API_KEY");
```

After instantiating, the user are able to query a location with the LocationRequest's method query, which returns a JSON in string format.

```
String out = request.query("Berlin, Germany");
```

Alternatively, query can include more fields by defining it in the second parameter. Input fields keywords has to be separated by commas without spaces. (Read more about fields at [Google Places API](https://developers.google.com/places/web-service/search)).

```
String out = request.query("Frankfurt","formatted_address,id,name");
```