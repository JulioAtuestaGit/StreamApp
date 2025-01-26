package com.example.demo.services;

import com.example.demo.model.MultipleProductions;
import com.example.demo.model.Production;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public final class InputHandler {
    private static String userRequest;
    private static int userSelection;
    public static void inputs(int userSelection) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);
        ApiRequest apiRequest = new ApiRequest();
        ObjectMapper mapper = new ObjectMapper();

        switch (userSelection){
            case 1:
                System.out.println("Ingresa el nombre de la Pelicula que deseas buscar :");
                userRequest=scanner.nextLine();
                userRequest.replace(" ","+");
                String json = apiRequest.obtenerDatos(userRequest);
                Production movie = mapper.readValue(json,Production.class);

                break;

            case 2:
                System.out.println("Ingresa el nombre de la Serie que deseas buscar :");
                userRequest=scanner.nextLine();
                break;
            case 3:
                System.out.println("Ingresa el nombre del Episodio que deseas buscar :");
                userRequest=scanner.nextLine();
                break;
            case 4:
                System.out.println("Ingresa palabra clave que deseas buscar :");
                userRequest=scanner.nextLine();
                userRequest.replace(" ","+");
                json = apiRequest.obtenerDatos(userRequest);
                MultipleProductions allProds = mapper.readValue(json,MultipleProductions.class);
                int initialSize =Math.ceilDiv(Integer.valueOf(allProds.getTotal()),allProds.getShortProductions().size());
                System.out.println("NUMERO DE CICLOS SSSSSSSSS::::::::::::::: SSSSSS "+ initialSize);
                if (allProds.getShortProductions().size()<Integer.valueOf(allProds.getTotal())){
                    for(int i = 2; i < initialSize; i++){
                        String newPage = apiRequest.obtenerDatos(userRequest,i);
                        MultipleProductions newPages = mapper.readValue(newPage,MultipleProductions.class);
                        for (int j=0; j<newPages.getShortProductions().size();j++){
                            allProds.getShortProductions().add(newPages.getShortProductions().get(j));
                        }
                    }
                    System.out.println(allProds.toString());
                }
                break;

        }

    }
}
