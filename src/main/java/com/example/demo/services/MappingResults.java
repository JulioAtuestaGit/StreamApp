package com.example.demo.services;
import com.example.demo.model.MultipleProductions;
import com.example.demo.model.Production;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public final class MappingResults {

        static Scanner scanner = new Scanner(System.in);
        static ApiRequest apiRequest = new ApiRequest();
        static ObjectMapper mapper = new ObjectMapper();
        static String userRequest;
        static String json;

    public static void simpleMapping() throws JsonProcessingException {
        System.out.println("Que deseas ver hoy?");
        userRequest = scanner.nextLine();
        json = apiRequest.obtenerDatos(userRequest);
        Production movie = mapper.readValue(json, Production.class);
        if(movie.getTotal()==null || "Null".equals(movie.getTotal())){
            MultipleMapping();
            } else {
                System.out.println(movie);
            }
        }

    public static void MultipleMapping() throws JsonProcessingException {
        // json = apiRequest.obtenerDatos(userRequest);
            MultipleProductions allProds = mapper.readValue(json, MultipleProductions.class);
            int initialSize = Math.ceilDiv(Integer.valueOf(allProds.getTotal()), allProds.getShortProductions().size());

            // System.out.println("NUMERO DE CICLOS SSSSSSSSS::::::::::::::: SSSSSS "+ initialSize);
            if (allProds.getShortProductions().size() == Integer.valueOf(allProds.getTotal())) {
            } else if (allProds.getShortProductions().size() < Integer.valueOf(allProds.getTotal())) {
                for (int i = 2; i < initialSize; i++) {
                    String newPage = apiRequest.obtenerDatos(userRequest, i);
                    MultipleProductions newPages = mapper.readValue(newPage, MultipleProductions.class);
                    for (int j = 0; j < newPages.getShortProductions().size(); j++) {
                        allProds.getShortProductions().add(newPages.getShortProductions().get(j));
                    }
                }
            } else {
                System.out.println("Da Fuck");
            }
            System.out.println(allProds);
        }
}
