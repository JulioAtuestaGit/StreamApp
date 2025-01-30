package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortProduction {
        @JsonAlias("Title")
        private String title;
        @JsonAlias("Year")
        private String year;
        @JsonAlias("Type")
        private String type;

    public String getTitle() {return title;}
    public String getYear() {return year;}
    public String getType() {return type;}

    public void play(){
        System.out.println("Now playing :"+this.getTitle());
    }
    @Override
    public String toString() {
        return "\nTitle: "+ title
            +"\nYear: "+year
            +"\nType :"+type;
    }
}
