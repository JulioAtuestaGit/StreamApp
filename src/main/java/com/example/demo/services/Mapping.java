package com.example.demo.services;
import com.example.demo.model.MultipleProductions;
import com.example.demo.model.Production;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.StringMap;

import javax.swing.event.ListSelectionEvent;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class Mapping {
    private static String userRequest;
    static Scanner scanner = new Scanner(System.in);
    static ApiRequest apiRequest = new ApiRequest();
    static ObjectMapper mapper = new ObjectMapper();

    public static  void filterProductions(MultipleProductions allprods){
        int menu=0;
        int selection=0;
        System.out.println("""
                1- Chose a Tilte:
                2- Filter Results:
                3- Search again:
                """);
            menu = scanner.nextInt();
        switch (menu){
            case 1:
                System.out.println("Type title number :\n");
                selection = scanner.nextInt();
                allprods.getShortProductions().get(selection+1).play();
                break;
            case 2:
                System.out.println("""
                        1- Filter filteredResults
                        2- Filter Movies
                        3- Filter Games
                        4- Filter by year 
                        """);
                selection = scanner.nextInt();

                            MultipleProductions filteredResults = new MultipleProductions();
                    switch (selection){
                        case 1:
                            //change remove for filter to set series to keep the og list
                            filteredResults.setShortProductions(allprods.getShortProductions().stream().filter(
                                    production -> "series".equals(production.getType())).collect(Collectors.toList()));

                            /* same reference
                            filteredResults.getShortProductions().removeIf(shortProduction -> !"filteredResults".equals(shortProduction.getType()));
                            */
                            filteredResults.setTotal(String.valueOf(filteredResults.getShortProductions().size()));
                            System.out.println(filteredResults);
                            break;
                        case 2:
                            filteredResults.setShortProductions(allprods.getShortProductions().stream().filter(
                                    production -> "movie".equals(production.getType())).collect(Collectors.toList()));
                            filteredResults.setTotal(String.valueOf(filteredResults.getShortProductions().size()));
                            System.out.println(filteredResults);
                            break;
                        case 3:
                            filteredResults.setShortProductions(allprods.getShortProductions().stream().filter(
                                    production -> "game".equals(production.getType())).collect(Collectors.toList()));
                            filteredResults.setTotal(String.valueOf(filteredResults.getShortProductions().size()));
                            System.out.println(filteredResults);
                            break;
                        case 4:
                            /* FILTRAR POR AÑO */
                            int initialYear =0;
                            int finalYear=0;
                            System.out.println("""
                            Select TimeFrame:
                            Type year lower limit:
                            """);
                            initialYear = scanner.nextInt();
                            System.out.println("""
                            Select TimeFrame:
                            Type year upper limit:
                            """);
                            finalYear = scanner.nextInt();
                            break;
                }
            case 3:
                /*nueva busqeuda*/
                break;
        }
    }

    public static void multipleMapping() throws JsonProcessingException {
        System.out.println("Search:");
        userRequest = scanner.nextLine();
        userRequest = userRequest.replace(" ","+");
        String json = apiRequest.apirequest(userRequest,1);
        System.out.println(json);
        MultipleProductions allProds = mapper.readValue(json,MultipleProductions.class);
        System.out.println(allProds);
        int pages =Math.ceilDiv(Integer.valueOf(allProds.getTotal()),allProds.getShortProductions().size());

                if (allProds.getShortProductions().size() < Integer.valueOf(allProds.getTotal())) {
                    for (int i = 2; i < pages+1; i++) {
                        String newPage = apiRequest.apirequest(userRequest, i);
                        MultipleProductions newPages = mapper.readValue(newPage, MultipleProductions.class);
                        for (int j = 0; j < newPages.getShortProductions().size(); j++) {
                            allProds.getShortProductions().add(newPages.getShortProductions().get(j));
                        }
                    }
                    System.out.println(allProds);
                }else if (allProds.getShortProductions().size() > Integer.valueOf(allProds.getTotal())){
                    System.out.println("*** No Possible ***");
                }
        filterProductions(allProds);
        }
    }

