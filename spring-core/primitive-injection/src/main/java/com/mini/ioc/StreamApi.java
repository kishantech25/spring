package com.mini.ioc;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class StreamApi {

    public static String liveDate(String apiUrl){
        HttpResponse<String> response=null;
        String s=null;
        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            // Send request and get response as String
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code : " + response.statusCode());

            System.out.println("\nAPI Response:");
            //   System.out.println(response.body());
            s=response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    return s;
    }
}
