package com.example.demo.model;

import com.example.demo.model.Production;
import com.example.demo.services.ApiRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleProductions {
    @JsonAlias("totalResults")
    private String total;
    @JsonAlias("Response")
    private String response;
    @JsonAlias("Search")
    private List<Production> productions = new ArrayList<>();
    public String getTotal() {return total;}
    public String getResponse() {return response;}
    public List<Production> getProductions() {return productions;}

    public void arrai() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();  //mover a una funcion en otro lado
        String json = ApiRequest.obtenerDatos("batman", 1);
        MultipleProductions multipleProductions = mapper.readValue(json, MultipleProductions.class);
        this.productions = multipleProductions.getProductions();
    }
}
// for(int i=0; i<Integer.parseInt(getTotal()); i++)    {
// productions.add(mapper.readValue(json,new TypeReference<List<Production>>(){}));
//        }






