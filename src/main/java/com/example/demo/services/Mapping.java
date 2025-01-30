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
        FilterProduction.filterProductions(allProds);

        }
    }

