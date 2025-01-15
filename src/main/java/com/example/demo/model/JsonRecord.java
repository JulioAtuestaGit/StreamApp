//package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record JsonRecord() {}
    @JsonAlias("Title")//Json alias only reading // Jsonproperty also writing
    String title;
    @JsonAlias("Year")
    int year;
    @JsonAlias("Genre")
    String genre;
    @JsonAlias("Runtime")
    int duration;
    @JsonAlias("Plot")
    String description;

public void main() {
}

