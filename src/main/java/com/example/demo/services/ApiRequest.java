package com.example.demo.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private static String apiUrl="http://www.omdbapi.com/?s=%s&apikey=da800df0";

    //methods
    public String getApiUrl() {return apiUrl;}

    public static String obtenerDatos(String input) {
        String request = String.format(apiUrl,input);
        System.out.println("URL: "+ request);
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

    /*
    *
    *  CAMNIAR URL usar T S type EPISODE y page
    *
    * */


    public static String obtenerDatos(String input, int page) {
        String request = String.format(apiUrl,input) + "&page=" +page;
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

   public static String htppRequest(String jsonResponse){
  /*crear metodo que cree la url T s type episode y page y llama al coso la url se envia en forma de que ? string array
  * como identifica le metodo nuevo que tine pages  esto entra en conflicto con el single  y el multiple ?*/
       return null;
   }
}
