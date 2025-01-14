package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class JsonClass {
    @JsonAlias("Title")//Json alias only reading // Jsonproperty also writing
    private String title;
    @JsonAlias("Year")
    private int year;
    @JsonAlias("Genre")
    private String genre;
    @JsonAlias("Runtime")
    private int duration;
    @JsonAlias("Plot")
    private String description;

}
