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
				Selecciona search type :
				1 - Pelicula
				2 - Serie
				3 - Episode
				4 - Keywords
				""");
        userSelection = scanner.nextInt();
        switch (userSelection){
            case 1:
                System.out.println("Ingresa el nombre de la Pelicula que deseas buscar :");
                userRequest=scanner.nextLine();
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
                System.out.println("Ingresa pala clave que deseas buscar :");
                userRequest=scanner.nextLine();
                break;
        }

        String json = apiRequest.obtenerDatos(userRequest);//solo busca el titulo cambiar para buscar por temporada en caso de ser serie o por keywords o director
        Production jsonMapped = mapper.readValue(json,Production.class);
        System.out.println(jsonMapped.toString());
    }
}
