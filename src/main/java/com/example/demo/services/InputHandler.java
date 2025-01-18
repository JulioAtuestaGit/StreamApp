package com.example.demo.services;

import com.example.demo.model.Production;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public final class InputHandler {
    private static String userRequest;
    private static int userSelection;
    public static void inputs() throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);
        ApiRequest apiRequest = new ApiRequest();
        ObjectMapper mapper = new ObjectMapper();
        /*Entrada mover a clase*/
        System.out.println("""
				Selecciona el tipo de busqueda:
				1 - Pelicula
				2 - Serie
				""");
        if (scanner.nextInt() == 1){
            System.out.println("Ingresa el nombre de la Pelicula que deseas buscar :");
            userRequest=scanner.nextLine();
        } else if (scanner.nextInt() == 2) {
            System.out.println("Ingresa el nombre de la Eerie que deseas buscar :");
            userRequest=scanner.nextLine();
        }
        String json = apiRequest.obtenerDatos(userRequest);
        Production jsonMapped = mapper.readValue(json,Production.class);
        System.out.println(jsonMapped.toString());
    }
}
