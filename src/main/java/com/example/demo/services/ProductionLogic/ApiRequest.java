package com.example.demo.services.ProductionLogic;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private static String apiUrl="http://www.omdbapi.com/?s=%s&apikey=da800df0";

/*
        Definir metodo para URL S y url
        especifica T + opciones de typo y año

     */

    public static String apirequest(String input, int page){
        String request = String.format(apiUrl,input) + "&page=" +page;
        System.out.println("URL: "+ request);
        return obtenerDatos(request);
    }

    public static String obtenerDatos(String request) {
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
        return json;
    }
}
