package com.example.demo.model;
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
    private List<ShortProduction> shortProductions = new ArrayList<>();

    public String getTotal() {return total;}
    public String getResponse() {return response;}
    public List<ShortProduction> getShortProductions() {return shortProductions;}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1; i<=shortProductions.size();i++){
            stringBuilder.append("Resultado ").append(i).append(":").append(shortProductions.get(i-1).toString()).append("\n\n");
        }
         return this.getResponse()+" : "+this.getTotal()+"\n\n"+stringBuilder;
    }
}







