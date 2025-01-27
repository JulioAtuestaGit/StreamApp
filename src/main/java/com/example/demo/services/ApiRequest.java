package com.example.demo.services;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private static String apiUrl;

    //methods
    public static String getApiUrl() {return apiUrl;}
    public static void setApiUrl(String userRequest){
        apiUrl = null;
        apiUrl = "http://www.omdbapi.com/?" + "t=%s"+"&apikey=da800df0";
        apiUrl = String.format(apiUrl,userRequest);
    }
    public static void setApiUrl(String input, int page){
        apiUrl=null;
        apiUrl = "http://www.omdbapi.com/?" + "s=%s"+"&apikey=da800df0"+ "&page=" +page;
        apiUrl= String.format(apiUrl,input);
    }

    public static String obtenerDatos(String userRequest) {
        setApiUrl(userRequest);
        String request = getApiUrl();
        System.out.println(request);
        return request(request);
    }

    public static String obtenerDatos(String input, int page) {//multiple pages results
        setApiUrl(input,page);
        String request = getApiUrl();
        System.out.println(request);
        return request(request);
    }

    public static String request(String request){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(request)).build();
        HttpResponse<String> jsonResponse;
        try {
            jsonResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = jsonResponse.body();
        System.out.println(json);////////////////////////////////////////
        return json;
    }


}
