package com.example.demo.services;
import com.example.demo.model.MultipleProductions;
import com.example.demo.model.Production;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public final class InputHandler {
    private static String userRequest;
    public static void inputs( ) throws JsonProcessingException {

        Scanner scanner = new Scanner(System.in);
        ApiRequest apiRequest = new ApiRequest();
        ObjectMapper mapper = new ObjectMapper();

                System.out.println("que deseas ver:");
                userRequest=scanner.nextLine();
                String json = apiRequest.obtenerDatos(userRequest);
                System.out.println(json);

                MultipleProductions allProds = mapper.readValue(json,MultipleProductions.class);
                System.out.println(allProds);
                int initialSize =Math.ceilDiv(Integer.valueOf(allProds.getTotal()),allProds.getShortProductions().size());

                if (allProds.getShortProductions().size()<Integer.valueOf(allProds.getTotal())){
                    System.out.println("NUMERO DE CICLOS SSSSSSSSS::::::::::::::: SSSSSS "+ initialSize);
                    for(int i = 2; i < initialSize; i++){
                        String newPage = apiRequest.obtenerDatos(userRequest,i);
                        MultipleProductions newPages = mapper.readValue(newPage,MultipleProductions.class);
                        for (int j=0; j<newPages.getShortProductions().size();j++){
                            allProds.getShortProductions().add(newPages.getShortProductions().get(j));
                        }
                    }
                    System.out.println(allProds.toString());
                }


        }

    }

