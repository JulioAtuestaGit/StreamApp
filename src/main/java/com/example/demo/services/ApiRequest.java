package com.example.demo.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private static String apiUrl="http://www.omdbapi.com/?s=%s&apikey=da800df0";
    public static String obtenerDatos(String input, int type) {
        String request = String.format(apiUrl,input);
        System.out.println(request);  /////////////////////////URL
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(request)).build();
        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = jsonResponse.body();
        System.out.println("API ::::::"+json);////////////////////////json response
        return json;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
