package com.example.demo.services;
import com.example.demo.model.MultipleProductions;
import com.example.demo.model.Production;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public final class Mapping {
    private static String userRequest;
    static Scanner scanner = new Scanner(System.in);
    static ApiRequest apiRequest = new ApiRequest();
    static ObjectMapper mapper = new ObjectMapper();

    public static void singleMapping( ) throws JsonProcessingException {
        System.out.println("que deseas ver:");
        userRequest=scanner.nextLine();
        String json = apiRequest.obtenerDatos(userRequest);
        Production production = mapper.readValue(json,Production.class);
        System.out.println(production);

        System.out.println("""
                1- Play this tittle
                2- Show more results
                3- Search New titlle
                """);
        /* mostrar mas resultados llama a multiple
        * busqueda nueva recursividad
        * ver esta pelicula llama a nowplaying*/
        int userSelection = scanner.nextInt();
        if(userSelection == 1 ){
            production.play();
        }else if (userSelection == 2){
           //a multipleMapping(json);
        } else {
            singleMapping(); // al usar recursividad no pregunta de neuvo que se quiere ver
        }
    }

    public static void multipleMapping(/*String json*/) throws JsonProcessingException {
        System.out.println("que deseas ver:");
        userRequest=scanner.nextLine();
        String json = apiRequest.obtenerDatos(userRequest);
        System.out.println(json);
        MultipleProductions allProds = mapper.readValue(json,MultipleProductions.class);
        System.out.println(allProds);
        int pages =Math.ceilDiv(Integer.valueOf(allProds.getTotal()),allProds.getShortProductions().size());

                if (allProds.getShortProductions().size() < Integer.valueOf(allProds.getTotal())) {
                    //System.out.println("NUMERO DE CICLOS SSSSSSSSS::::::::::::::: SSSSSS " + pages);
                    for (int i = 2; i < pages; i++) {
                        String newPage = apiRequest.obtenerDatos(userRequest, i);
                        MultipleProductions newPages = mapper.readValue(newPage, MultipleProductions.class);
                        for (int j = 0; j < newPages.getShortProductions().size(); j++) {
                            allProds.getShortProductions().add(newPages.getShortProductions().get(j));
                        }
                    }
                    System.out.println(allProds);
                }else if (allProds.getShortProductions().size() > Integer.valueOf(allProds.getTotal())){
                    System.out.println("*** No Possible ***");
                }
        }
    }

